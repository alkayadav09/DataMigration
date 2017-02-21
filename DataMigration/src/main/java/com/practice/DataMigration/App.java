package com.practice.DataMigration;

import java.util.ArrayList;
import java.util.List;

import com.practice.DataMigration.DAO.DestinationData;
import com.practice.DataMigration.DAO.SourceData;
import com.practice.DataMigration.Model.SUser;

public class App 
{
    public static void main( String[] args )
    {
    	SourceData sourceData = new SourceData();
    	List<SUser> sUser = new ArrayList<SUser>();
 //   	sourceData.saveData();
    	sUser = sourceData.getData();
        
    	DestinationData dData = new DestinationData();
        dData.saveData(sUser);
        
        
        
        
    }
}
