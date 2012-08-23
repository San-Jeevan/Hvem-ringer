package no.android.hvem.ringer;



import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import android.content.Context;
import android.os.AsyncTask;

public class PlateInfoTask extends AsyncTask<String, Void, InfoPack> {
   
	private TaskCallback handler;
	
    public PlateInfoTask(TaskCallback handler, Context context) {
   		this.handler = handler;
   	}
    

	protected InfoPack doInBackground(String... phonenumbers) {
		for (String url : phonenumbers) {

			InfoPack infoPack = null; 
			  try {  
			    SAXParserFactory spf = SAXParserFactory.newInstance(); 
			    SAXParser sp = spf.newSAXParser(); 
			    XMLReader xr = sp.getXMLReader(); 
			    GulePrivatDataHandler dataHandler = new GulePrivatDataHandler(); 
			    xr.setContentHandler(dataHandler); 
			    xr.parse(Config.gsider_private.replace("replaceme", url)); 
			    infoPack = dataHandler.getData(); 
			    if (infoPack.name == null) {
			    	Logg.d("second");
			    	GuleBedriftDataHandler bedriftdataHandler = new GuleBedriftDataHandler(); 
			    	xr.setContentHandler(bedriftdataHandler); 
				    xr.parse(Config.gsider_bedrift.replace("replaceme", url)); 
				    infoPack = bedriftdataHandler.getData(); 	
			    }
			  } catch(ParserConfigurationException pce) { 
			    Logg.e("sax parse error"); 
			  } catch(SAXException se) { 
			    Logg.e("sax error SAXexception"); 
			  } catch(IOException ioe) { 
			    Logg.e("sax parse io error"); 
			  } 
			  infoPack.nr = url;
			  Logg.d("midt i: " + infoPack.name);
			  return infoPack; 
			} 
		return null;
	}

	
	protected void onPostExecute(InfoPack ip) {
		super.onPostExecute(ip);
		handler.onComplete(ip);
	}
	 
	
}
