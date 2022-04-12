import java.util.Arrays;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.DataOutputStream;
class ChemicalElement implements java.io.Serializable {

    private String name;
    private String symbol;
    private int atomicNumber;
    private String[] bondsWith;

    public ChemicalElement(String name, String symbol, int atomicNumber, String[] bonds) {
        this.setName(name);
        this.setSymbol(symbol);
        this.setAtomicNumber(atomicNumber);
        this.setBonds(bonds);
    }

    public boolean bondsWith(String symbol) {
        return Arrays.asList(this.getBonds()).contains(symbol);
    }

    public int getAtomicNumber() {
        return this.atomicNumber;
    }

    public String[] getBonds() {
        return this.bondsWith;
    }

    public String getName() {
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void print() {
        System.out.println("=== " + this.getName() + " ===");
        System.out.println("Symbol: " + this.getSymbol());
        System.out.println("Atomic Number: " + this.getAtomicNumber());
        System.out.println("bondsWith: " + Arrays.toString(this.getBonds()));
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public void setBonds(String[] bonds) {
        this.bondsWith = bonds;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String toJSON(){
        String atomBonds = "[";
        for(int i = 0; i < bondsWith.length; i++){
            if(i == bondsWith.length - 1){
                atomBonds += "\"" + bondsWith[i] + "\"";
            } else {
                atomBonds += "\"" + bondsWith[i] + "\", ";
            }
            
        }
        atomBonds += "]";
        String returnJSON = "{\n   " + "\"atomicNumber\": " + this.getAtomicNumber() + ",\n   " + "\"bondsWith\": " + atomBonds + ",\n   " + "\"Name\": " + "\"" + this.getName() + "\"," + "\n   " + "\"Symbol\": " + "\"" + this.getSymbol() + "\"\n}\n";
        return returnJSON;
    }

    public String[] toJSONLines(){
        String atomBonds = "[";
        for(int i = 0; i < bondsWith.length; i++){
            if(i == bondsWith.length - 1){
                atomBonds += "\"" + bondsWith[i] + "\"";
            } else {
                atomBonds += "\"" + bondsWith[i] + "\", ";
            }
            
        }
        atomBonds += "]";
        String[] decodedJSON = {
            "{",
            "   \"atomicNumber\": " + this.getAtomicNumber() + ",",
            "   \"bondsWith\": " + atomBonds + ",",
            "   \"Name\": \"" + this.getName() + "\",",
            "   \"Symbol\": \"" + this.getSymbol() + "\"",
            "}"
        };
        return decodedJSON;
    }

    public void writeJSONFromLines(){
        String[] lines = this.toJSONLines();
        try(
            FileWriter fileWriter = new FileWriter(this.name + ".txt");
            PrintWriter printToFile = new PrintWriter(fileWriter);
        ) {
            for(int i = 0; i < lines.length; i++){
                printToFile.println(lines[i]);
            }
            printToFile.close();
            fileWriter.close();
        } catch(Exception e){}
    }

    public void writeJSON(){
        String fileContent = this.toJSON();
        try (FileWriter fileWriter = new FileWriter(this.getSymbol() + ".txt");){
            fileWriter.write(fileContent);
            fileWriter.close();
        } catch (Exception e){}
    }

    public static ChemicalElement readJSON(String fileToRead){
        String line = "";
        String name = "";
        String symbol = "";
        int atomicNumber = -1;
        String[] bonds = {};
        try(
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToRead));
        ) {
            while((line = bufferedReader.readLine()) != null){
                String[] parts = line.trim().split(":");
                if (parts.length == 1) continue;
                String clean_value = parts[1].split(",")[0].trim();
                switch (parts[0]) {
                    case "\"atomicNumber\"":
                        atomicNumber = Integer.parseInt(clean_value);
                        continue;
                    case "\"bondsWith\"":
                        clean_value = parts[1].trim();
                        clean_value = clean_value.substring(1, clean_value.length()-2 );
                        bonds = clean_value.split(",");
                        continue;
                    case "\"name\"":
                        name = clean_value;
                        continue;
                    case "\"symbol\"":
                        symbol = clean_value; continue;
                }
            }
            bufferedReader.close();
        } catch (Exception e){}
        return(new ChemicalElement(name, symbol, atomicNumber, bonds));
    }

    public void writeObject(){
        try{
            FileOutputStream fileInput = new FileOutputStream(this.getName() + ".obj");
            ObjectOutputStream objectInput = new ObjectOutputStream(fileInput);
            objectInput.writeObject(this);
            objectInput.close();
        } catch (Exception e) {
            System.out.println("Error: Failed To Serialise Object");
        }
        finally{
            System.out.println("The Object Serialisation Attempt Is Complete");
        }
    }

    public static ChemicalElement readObject(ObjectInputStream inputStream) throws RuntimeException {
        try{
            ChemicalElement elementNew = (ChemicalElement) inputStream.readObject();
            inputStream.close();
            return elementNew;
        } catch (Exception e) {
            System.out.println("Error: Failed To Read Serialised Object");
        }
        finally{
            System.out.println("The Attempt To Read The Serialised Object Is Complete");
        }
        return null;
    }

    public void writeBinary(){
        try(
            FileOutputStream fileInput = new FileOutputStream(this.getName() + ".bin");
            DataOutputStream objectInput = new DataOutputStream(fileInput);
            )
        {
            objectInput.writeUTF(this.toJSON());
            objectInput.close();
        }
        catch (Exception e)
        {
            
        }
        finally
        {
            System.out.println("The Attempt To Write JSON To Binary Is Complete");
        }
        
    }


}
