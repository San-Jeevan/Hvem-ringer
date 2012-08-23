package no.android.hvem.ringer;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GuleBedriftDataHandler extends DefaultHandler {

	// booleans that check whether it's in a specific tag or not
	private boolean _inCompanyName, _inStreetName, _inPostCode, _inPostArea;

	// this holds the data
	private InfoPack _data;

	/**
	 * Returns the data object
	 * 
	 * @return
	 */
	public InfoPack getData() {
		return _data;
	}

	/**
	 * This gets called when the xml document is first opened
	 * 
	 * @throws SAXException
	 */
	@Override
	public void startDocument() throws SAXException {
		_data = new InfoPack();
	}

	/**
	 * Called when it's finished handling the document
	 * 
	 * @throws SAXException
	 */
	@Override
	public void endDocument() throws SAXException {

	}

	/**
	 * This gets called at the start of an element. Here we're also setting the
	 * booleans to true if it's at that specific tag. (so we know where we are)
	 * 
	 * @param namespaceURI
	 * @param localName
	 * @param qName
	 * @param atts
	 * @throws SAXException
	 */
	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {

		if (qName.equals("e:company_name")) {
			_inCompanyName = true;
		} else if (qName.equals("e:street_name")) {
			_inStreetName = true;
		} else if (qName.equals("e:post_code")) {
			_inPostCode = true;
		} else if (qName.equals("e:post_area")) {
			_inPostArea = true;
		}

	}

	/**
	 * Called at the end of the element. Setting the booleans to false, so we
	 * know that we've just left that tag.
	 * 
	 * @param namespaceURI
	 * @param localName
	 * @param qName
	 * @throws SAXException
	 */
	@Override
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException {

		if (qName.equals("e:company_name")) {
			_inCompanyName = false;
		} else if (qName.equals("e:street_name")) {
			_inStreetName = false;
		} else if (qName.equals("e:post_code")) {
			_inPostCode = false;
		} else if (qName.equals("e:post_area")) {
			_inPostArea = false;
		}
	}

	/**
	 * Calling when we're within an element. Here we're checking to see if there
	 * is any content in the tags that we're interested in and populating it in
	 * the Config object.
	 * 
	 * @param ch
	 * @param start
	 * @param length
	 */
	@Override
	public void characters(char ch[], int start, int length) {
		String chars = new String(ch, start, length);
		chars = chars.trim();
		if (_inCompanyName) {
			_data.name = chars;
		} else if (_inStreetName) {
			_data.addr = chars;
		} else if (_inPostArea) {
			_data.postSted = chars;
		} else if (_inPostCode) {
			_data.postNummer = chars;
		}

	}
}
