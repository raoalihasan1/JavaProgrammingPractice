import java.util.Arrays;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class ElementDriver {

    public static void main(String args[]) {

        String[] covalentBondsH = {"H", "O", "N", "C"};
        ChemicalElement hydrogen = new ChemicalElement(
            "Hydrogen", "H", 1, covalentBondsH
        );

        String[] covalentBondsO = {"O", "H", "C"};
        ChemicalElement oxygen = new ChemicalElement(
            "Oxygen", "O", 8, covalentBondsO
        );

        String[] covalentBondsN = {"H", "N"};
        ChemicalElement nitrogen = new ChemicalElement(
            "Nitrogen", "N", 7, covalentBondsN
        );

        // System.out.println(hydrogen.toJSON());
        // System.out.println(oxygen.toJSON());
        // System.out.println(nitrogen.toJSON());

        // System.out.println(Arrays.toString(hydrogen.toJSONLines()));
        // System.out.println(Arrays.toString(oxygen.toJSONLines()));
        // System.out.println(Arrays.toString(nitrogen.toJSONLines()));

        // hydrogen.writeJSONFromLines();
        // oxygen.writeJSONFromLines();
        // nitrogen.writeJSONFromLines();
        
        // hydrogen.writeJSON();
        // oxygen.writeJSON();
        // nitrogen.writeJSON();

        // ChemicalElement phosphorus = ChemicalElement.readJSON("Phosphorus.txt");
        // System.out.println(phosphorus.getName().substring(1,phosphorus.getName().length()-1) + " Has Symbol " + phosphorus.getSymbol().substring(1,phosphorus.getSymbol().length()-1) + " And Atomic Number " + phosphorus.getAtomicNumber());

        // try{
        //     ObjectInputStream objInput = new ObjectInputStream(new FileInputStream("Oxygen.obj"));
        //     ChemicalElement newHydrogen = ChemicalElement.readObject(objInput);
        //     System.out.println("Atom Name: " + newHydrogen.getName());
        //     System.out.println("Atom Symbol: " + newHydrogen.getSymbol());
        //     System.out.println("Atomic Number: " + newHydrogen.getAtomicNumber());
        // }
        // catch (Exception e) {
        //     System.out.println("Error: A File With This Name Does Not Exist In This Directory");
        // }

        oxygen.writeBinary();
        
    }
}

