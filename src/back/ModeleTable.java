package back;

import java.util.ArrayList;

public class ModeleTable {
	
	private String name;
	private String[] ColumnsName;
	private ArrayList<String> ColumnsData;
	
	public ModeleTable(String name, String[] columns,ArrayList<String> ColumnsData) {
		this.name = name;
		this.ColumnsName = columns;
		this.ColumnsData = ColumnsData;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getColumnsName() {
		return ColumnsName;
	}

	public void setColumnsName(String[] columnsName) {
		ColumnsName = columnsName;
	}

	public ArrayList<String> getColumnsData() {
		return ColumnsData;
	}

	public void setColumnsData(ArrayList<String> columnsData) {
		ColumnsData = columnsData;
	}
}
