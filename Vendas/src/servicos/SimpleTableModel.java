package servicos;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class SimpleTableModel extends AbstractTableModel{
    private ArrayList linhas = null;
    private String [] colunas = null;

   public ArrayList getLinhas(){
       return linhas;
   }
   
   public void setLinhas(ArrayList list){
      linhas = list; 
   }
   public void setColunas(String [] strings){
       colunas = strings;
   }
   
   public String [] getColunas(){
       return colunas;
   }
   
    @Override
    public int getRowCount() {
      return getLinhas().size();
    }

    @Override
    public int getColumnCount() {
      return getColunas().length;
    }

    @Override
    public String getColumnName(int coluna){
      return colunas[coluna];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
      String [] linha = (String [])getLinhas().get(rowIndex);
      return linha[colIndex];
    }

    public SimpleTableModel(ArrayList dados, String[] colunas) {
        this.setColunas(colunas);
        this.setLinhas(dados);
    }     
}