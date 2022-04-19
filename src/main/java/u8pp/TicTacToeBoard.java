package u8pp;


public class TicTacToeBoard {

    String[][] data;

    public TicTacToeBoard(String[][] data) {
        this.data = data;
    }

    public String toString() {
        String output = "";
        for(int r = 0; r < data.length; r++) {
            if(r != 0) {
                output += "\n";
                output += "-+".repeat(data[r].length - 1);
                output += "-";
                output += "\n";
            }
            for(int c = 0; c < data[r].length; c++) {
                if(c != 0) {
                    output += "|";
                }
                output += data[r][c];
            }
        }
        return output;
    }

    public boolean hasWin() {
        return hasDiagonalWin() || hasHorizontalWin() || hasVerticalWin();
    }

    public boolean hasHorizontalWin() {
      boolean win = false;
      for(int i = 0; i < data.length; i++){
        for(int j = 0; j < data[i].length; j++){
          String piece = "";
          if(j == 0 ){
            piece = data[i][j];
          }
          else if(data[i][j] != piece){
            win = false;
          }
          else{
            win = true;
          }
        }
        if (win == true){
          return win;
        }
      }
      return win;
    }

    public boolean hasVerticalWin() {
      int n = 0;
      int j = 0;
      boolean win = false;
      while(j < data[n].length){
        for(int i = 0; i < data.length; i++){
          String piece = "";
          if(i == 0){
            piece = data[i][j];
          }
          else if(data[i][j] != piece){
            win = false;
          }
          else{
            win = true;
          }
        }
        if (win == true){
          return win;
        }
        else{
          j++;
        }
      }
      return win;
    }

    public boolean hasDiagonalWin() {
      boolean win = false;
      int i = 0;
          for(int j = 0; j < data[i].length; j++){
            String piece = "";
            if(j == 0){
              piece = data[i][j];
            }
            else if(data[i][j] != piece){
              win = false;
            }
            else{
              win = true;
            }
            i++;
          }
      i = data.length -1;
      for(int j = 0; j < data[i].length; j++){
            String piece = "";
            if(j == 0){
              piece = data[i][j];
            }
            else if(data[i][j] != piece){
              win = false;
            }
            else{
              win = true;
            }
            i--;
          }
      return win;
        }
    /* helper functions go here */
   
}
