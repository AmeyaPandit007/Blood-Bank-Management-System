import javax.swing.text.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

public class CRUDOperation 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		MongoClient mc = new MongoClient("localhost",27017);
		System.out.println("Collection Successfull.!");
		
		//MongoDatabase db = mc.getDatabase("Youtube");
		//System.out.println("Get Database is Successfull.");
		
        // if database doesn't exists, MongoDB will create it for you
        DB db = mc.getDB("Youtube");
        System.out.println("Get Database is Successfull.");

        /**** Get collection / table from 'testdb' ****/
        // if collection doesn't exists, MongoDB will create it for you
        DBCollection col = db.getCollection("Video2");
        System.out.println("Collection is created.!");
         
        BasicDBObject docu = new BasicDBObject("name","SimplyingTech");
        //Document doc = new Document("Name","SimplyingTech");
        docu.append("id",101);
        docu.append("Subscribers",1001);
        docu.append("Genre","Programming");
        col.insert(docu);
        System.out.println("Insert is Complete.!");
        
        BasicDBObject docu2 = new BasicDBObject("name","CarryMinati");
        //Document doc = new Document("Name","SimplyingTech");
        docu2.append("id",102);
        docu2.append("Subscribers",10001);
        docu2.append("Genre","Comedy");
        col.insert(docu2);
        System.out.println("Insert is Complete.!");
        
        DBCursor cur1 = col.find();
        while(cur1.hasNext())
        {
        	System.out.println(cur1.next());
        }
        
        
        BasicDBObject r1 = new BasicDBObject("name", "CarryMinati");
        col.remove(r1);
        
        //DBCursor cur1 = col.find();
        while(cur1.hasNext())
        {
        	System.out.println("***********************************");
        	System.out.println(cur1.next());
        }
        
	}

}
