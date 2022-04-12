import java.util.Random;

public class HangmanDictionary {

    private Random rand;
    private final int DICT_SIZE = 26;

    public HangmanDictionary() {
      rand = new Random();
    }

    /**
     * Returns a random dictionary word.
     * @return the word located at a randomly selected index.
     */
    public String getWord() {
        int i = this.rand.nextInt(DICT_SIZE);
        return this.getWord(i);
    }

    /**
     * Returns the dictionary word located at a specified index.
     * @param  index the index of the word to fetch.
     * @return the word located at the specified index.
     */
    public String getWord(int index) {
      switch (index) {
          case 1:
              return "awkward";
          case 2:
              return "banjo";
          case 3:
              return "crypt";
          case 4:
              return "dwarves";
          case 5:
              return "elephant";
          case 6:
              return "fishhook";
          case 7:
              return "gazebo";
          case 8:
              return "haphazard";
          case 9:
              return "ivory";
          case 10:
              return "jinx";
          case 11:
              return "klutz";
          case 12:
              return "mystify";
          case 13:
              return "numbskull";
          case 14:
              return "ostracize";
          case 15:
              return "pajama";
          case 16:
              return "quip";
          case 17:
              return "rhythmic";
          case 18:
              return "sphinx";
          case 19:
              return "twelfth";
          case 20:
              return "unzip";
          case 21:
              return "veritable";
          case 22:
              return "wassail";
          case 23:
              return "xylophone";
          case 24:
              return "yacht";
          case 25:
              return "zealous";
          default:
              return "hangman";
      }
    }
    
}
