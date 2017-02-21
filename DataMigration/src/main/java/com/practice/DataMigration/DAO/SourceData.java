package com.practice.DataMigration.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.practice.DataMigration.HibernateUtilities;
import com.practice.DataMigration.Model.SUser;

/*
	Here we have once saved about 100000 records in the Source Database and 
	then we are getting the data record from Source DB and Logging the time taken to fetch the records
	from the Source DB
*/

public class SourceData {

	private static final Logger LOG = Logger.getLogger(SourceData.class);
	
	public void saveData(){
		List<SUser> sUserList = new ArrayList<SUser>();
		for(int i=0; i<100000 ; i++){
			SUser sUser = new SUser();
	    	sUser.setFirstName("Sam");
	    	sUser.setLastName("Smith");
			sUser.setCreatedDate(new Date());
			sUser.setUpdatedDate(new Date());
			sUserList.add(sUser);
		}
		
		
        Session session = HibernateUtilities.getSession();
        session.beginTransaction();
        for(int i=0 ; i<sUserList.size(); i++){
        	session.save(sUserList.get(i));
        }
        
        session.getTransaction().commit();
       
	}
	
	public List<SUser> getData(){
		Session session = HibernateUtilities.getSession();
        session.beginTransaction();
        LOG.info("Time recorded before Data read" + new Date());
        Query query =  session.createQuery("Select s.firstName , s.lastName , "
        		+ "s.createdDate , s.updatedDate from SUser s");
        List<Object[]> rows = query.getResultList();
        List<SUser> sUserList = new ArrayList(rows.size());
        for(Object[] row : rows){
        	SUser sUser = new SUser();
        	sUser.setFirstName((String) row[0]);
        	sUser.setLastName((String) row[1]);
        	sUser.setCreatedDate((Date) row[2]);
        	sUser.setUpdatedDate((Date) row[3]);
        	
        	sUserList.add(sUser);
        }
        session.getTransaction().commit();
        LOG.info("Time recorded after Data read" + new Date());
        return sUserList;
	}
}
