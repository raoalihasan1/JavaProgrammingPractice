class magicWord {
	
	public static void printRow(String[][] Word, int Index){
		for(int i=0; i<Word[0].length; i++){
			System.out.print(Word[Index][i] + " ");
		}
		System.out.println("----------");
	}
    
	public static void printColumn(String[][] Word, int Index){
		for(int i=0; i<Word.length; i++){
			System.out.print(Word[i][Index] + " ");
		}
		System.out.println("----------");
	}

	public static void printDiagonal(String[][] Word, int Condition){
		int ArrayLength = Word.length - 1;
		if(Word.length == Word[0].length){
			switch (Condition){
				case 0:
					for(int i=0; i<Word.length; i++){
						System.out.print(Word[i][i] + " ");
					}
					System.out.println("----------");
				break;
				case 1:
					for(int i=0; i<Word.length; i++){
						System.out.print(Word[i][ArrayLength] + " ");
						ArrayLength -= 1;
					}
					System.out.println("----------");
				break;
			}
		} else {
			System.out.println("The Input Is Not A Square");
		}
	}

	public static void wordsRepeated(String[][] Word){
		int X = 0;
		String Num1 = "";
		String Num2 = "";
		if(Word.length == Word[0].length){
			while(X != Word.length){
				Num1 += Word[0][X];
				Num2 += Word[X][0];
				X += 1;
			}
			if(Num1.equals(Num2)){
				System.out.println("The Square Uses The Same Words Over The Rows And Columns");
			}
		} else {
			System.out.println("The Input Is Not A Square");
		}
	}

    public static void main(String[] args){
		String[][] Square2DA = {
			{"L","I","M","B"},
			{"A","R","E","A"},
			{"C","O","R","K"},
			{"K","N","E","E"}
		};
		String[][] Square2DB = {
			{"T","O","O"},
			{"U","R","N"},
			{"B","E","E"}
		};
		String[][] Square2DC = {
			{"S","C","E","N","T"},
			{"C","A","N","O","E"},
			{"A","R","S","O","N"},
			{"R","O","U","S","E"},
			{"F","L","E","E","T"}
		};
		String[][] Square2DD = {
			{"B","A","R","N"},
			{"A","R","E","A"},
			{"L","I","A","R"},
			{"L","A","D","Y"}
		};
		String[][] newSquare1 = {{"A"}};
		String[][] newSquare2 = {
			{"N","O"},
			{"O","N"}
		};
		String[][] newSquare3 = {
			{"B","I","T"},
			{"I","C","E"},
			{"T","E","N"}
		};
		String[][] newSquare4 = {
			{"C","A","R","D"},
			{"A","R","E","A"},
			{"R","E","A","R"},
			{"D","A","R","T"}
		};
		String[][] newSquare5 = {
			{"H","E","A","R","T"},
			{"E","M","B","E","R"},
			{"A","B","U","S","E"},
			{"R","E","S","I","N"},
			{"T","R","E","N","D"}
		};
		String[][] newSquare6 = {
			{"L","A","T","E","R","A","L","S"},
			{"A","X","O","N","E","M","A","L"},
			{"T","O","E","P","L","A","T","E"},
			{"E","N","P","L","A","N","E","D"},
			{"R","E","L","A","N","D","E","D"},
			{"A","M","A","N","D","I","N","E"},
			{"L","A","T","E","E","N","E","R"},
			{"S","L","E","D","D","E","R","S"}
		};
		String[][] Recatangles = {
			{"F","R","A","C","T","U","R","E"},
			{"O","U","T","L","I","N","E","D"},
			{"B","L","O","O","M","I","N","G"},
			{"S","E","P","T","E","T","T","E"}
		};
		printRow(Square2DA, 0);
		printColumn(Square2DA, 3);		
		printRow(Square2DB, 1);
		printColumn(Square2DB, 2);
		printRow(Square2DC, 3);
		printColumn(Square2DC, 0);
		printDiagonal(Square2DD, 0);
		printDiagonal(Square2DD, 1);
		wordsRepeated(newSquare1);
		wordsRepeated(newSquare2);
		wordsRepeated(newSquare3);
		wordsRepeated(newSquare4);
		wordsRepeated(newSquare5);
		wordsRepeated(newSquare6);
		printRow(Recatangles, 0);
		printColumn(Recatangles, 3);
		printDiagonal(Recatangles, 1);
		wordsRepeated(Recatangles);
	}

}
