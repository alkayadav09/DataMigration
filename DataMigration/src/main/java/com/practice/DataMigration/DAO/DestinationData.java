package com.practice.DataMigration.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.practice.DataMigration.HibernateUtilsDestination;
import com.practice.DataMigration.Model.DUser;
import com.practice.DataMigration.Model.SUser;

/*
	Here Source Date is Saved in the Destination DataBase and Logging the time taken to complete 
	transaction of saving the Data in the Destination DB
*/

public class DestinationData {
	
	private final static Logger LOG = Logger.getLogger(DestinationData.class); 
//	private final static Logger SourceLogger = Logger.getLogger("sourceLogger");
//	private final static Logger DestinationLogger = Logger.getLogger("destinationLogger");
	
	public void saveData(List<SUser> sUser){
		
		List<DUser> dUserList = new ArrayList<DUser>();
		DUser dUser;
		Iterator itr = sUser.iterator();
		/*while(itr.hasNext()){
			dUsr = new DUser();
			dUsr.setFirstName(sUser.get(i).getFirstName());
	        dUsr.setLastName(sUser.get(i).getLastName());
	        dUsr.setCreatedDate(sUser.get(i).getCreatedDate());
	        dUsr.setUpdatedDate(sUser.get(i).getUpdatedDate());
	        dUser.add(dUsr);
		}*/
		for(int i=0 ; i< sUser.size() ; i++){
			dUser = new DUser();
			dUser.setFirstName(sUser.get(i).getFirstName());
	        dUser.setLastName(sUser.get(i).getLastName());
	        dUser.setCreatedDate(sUser.get(i).getCreatedDate());
	        dUser.setUpdatedDate(sUser.get(i).getUpdatedDate());
	        dUserList.add(dUser);
		}
        Session dSession = HibernateUtilsDestination.getSession();
        dSession.beginTransaction();
        LOG.info("Data Migration started at : " + new Date());
        for(int i= 0 ; i < dUserList.size(); i++){
        	dSession.save(dUserList.get(i));
//        	LOG.info("Message logged");
        }
        dSession.getTransaction().commit();
        LOG.info("Data Migration Completed at : " + new Date());
		
	}
}
