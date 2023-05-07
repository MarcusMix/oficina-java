package models;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ClientesTB extends AbstractTableModel {
	
	private String[] colunas = new String[] { "Nome", "CPF", "E-mail","Telefone-1", "Cidade", "Estado" };
	
	private static final int NOME = 0;
	private static final int CPF = 1;
	private static final int EMAIL = 2;
	private static final int TELEFONE1 = 3;
	private static final int CIDADE = 4;
	private static final int ESTADO = 5;
	
	
	//clientes model
	private List<ClientModel> linhas;
	
	public ClientesTB(List<ClientModel> listaClientes) {
		linhas = new ArrayList<ClientModel>(listaClientes);
	}
	
	@Override
	public int getRowCount() {
		return linhas.size();
		
	}
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
	    return colunas[columnIndex];
	};
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
	    return false;
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	    // Pega o local referente a linha especificada.
		ClientModel clientes = linhas.get(rowIndex);
	 
	    switch (columnIndex) {
	    case NOME:
	        return clientes.getNome();
	    case CPF:
	        return clientes.getCpf();
	    case EMAIL:
	        return clientes.getEmail();
	    case TELEFONE1:
	        return clientes.getFone1();
	    case CIDADE:
	    	return clientes.getCidade();
	    case ESTADO:
	    	return clientes.getEstado();

	    
	    default:
	    
	        throw new IndexOutOfBoundsException("columnIndex out of bounds");
	    }}
	    
	    @Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		    // Seta o local referente a linha especificada.
			ClientModel clientes = linhas.get(rowIndex);
			
		 
		    switch (columnIndex) {
		    case NOME:
		    	clientes.setNome((String) aValue);
		    	break;
		    case CPF:
		    	clientes.setCpf((String) aValue);	
		    	break;
		    case EMAIL:
		    	clientes.setEmail((String) aValue);
		    	break;
		    case TELEFONE1:
		    	clientes.setFone1((String) aValue);
		        break;
		    case CIDADE: 	
		    	clientes.setCidade((String) aValue);
		    case ESTADO:
		    	clientes.setEstado((String) aValue);
		    default:
		        throw new IndexOutOfBoundsException("columnIndex out of bounds");
		    }
		     
		    fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
		
	}
	    
	 // Remove o local  da linha especificada.
	 		public void removeLocal(int indiceLinha) {
	 		    // Remove o registro.
	 		    linhas.remove(indiceLinha);
	 		 
	 		    // Notifica a mudança.
	 		    fireTableRowsDeleted(indiceLinha, indiceLinha);
	 		}
	 		 
	 		// Adiciona uma lista de local  no final da lista.
	 		public void addListaLocais(List<ClientModel> clientes) {
	 		    // Pega o tamanho antigo da tabela, que servirá
	 		    // como índice para o primeiro dos novos registros
	 		    int indice = getRowCount();
	 		 
	 		    // Adiciona os registros.
	 		    linhas.addAll(clientes);
	 		 
	 		    // Notifica a mudança.
	 		    fireTableRowsInserted(indice, indice + clientes.size());
	 		}
	 		 
	 		// Remove todos os registros.
	 		public void limpar() {
	 		    // Remove todos os elementos da lista de sócios.
	 		    linhas.clear();
	 		 
	 		    // Notifica a mudança.
	 		    fireTableDataChanged();
	 		}
	 		


}
