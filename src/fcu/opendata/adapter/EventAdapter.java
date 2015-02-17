package fcu.opendata.adapter;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import thewebsemantic.binding.Jenabean;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import fcu.opendata.jenabean.Event;
import fcu.opendata.jenabean.EventInstance;

public class EventAdapter {

	public static void main(String[] args) throws JDOMException, IOException,
			ParseException {

		OntModel ontModel = ModelFactory.createOntologyModel();
		Jenabean.instance().bind(ontModel);

		//File file = new File("xml/culture-event.xml");
		URL url = new URL("http://cloud.culture.tw/frontsite/trans/SearchShowAction.do?method=doFindTypeX&category=7&keyword=2013");
		//URL url = new URL("http://cloud.culture.tw/frontsite/trans/SearchShowAction.do?method=doFindTypeX&keyword=2013");
		SAXBuilder sax = new SAXBuilder();
		Document doc = sax.build(url);
		Element root = doc.getRootElement().getChild("eventItem")
				.getChild("event");// XML_Head/eventItem/event
		// System.out.println(root.getName());
		List<Element> infos = root.getChildren();

		for (Element e : infos) {
			Event event = new Event();
			event.setId(e.getAttributeValue("UID"));
			event.setTitle(e.getAttributeValue("title"));
			event.setCategory(e.getAttributeValue("category"));
			event.setProducer(e.getAttributeValue("showUnit"));
			event.setDescription(e.getAttributeValue("descriptionFilterHtml"));
			event.setDiscountInfo(e.getAttributeValue("discountInfo"));
			event.setImageUrl(e.getAttributeValue("imageUrl"));
			event.setHostingParty(e.getAttributeValue("masterUnit"));
			event.setAssociateHostingParty(e.getAttributeValue("subUnit"));
			event.setSponsor(e.getAttributeValue("supportUnit"));
			event.setRelatedParty(e.getAttributeValue("otherUnit"));
			event.setBookingWebsiteUrl(e.getAttributeValue("webSales"));
			event.setSourceWebsiteUrl(e.getAttributeValue("sourceWebPromote"));
			event.setSourceWebsite(e.getAttributeValue("sourceWebName"));
			event.setStartDate(TimeUtils.fromDateString(e
					.getAttributeValue("startDate")));
			event.setEndDate(TimeUtils.fromDateString(e
					.getAttributeValue("endDate")));

			// prob for show info
			if (!(null == e.getChild("showInfo"))
					&& (e.getChild("showInfo").getChildren().size() != 0)) {
				List<Element> elements = e.getChild("showInfo").getChildren();
				for (Element showElement : elements) {
					EventInstance ei = new EventInstance();
					ei.setId(UUID.randomUUID().toString());
					ei.setTime(TimeUtils.fromDateTimeString(showElement
							.getAttributeValue("time")));
					ei.setLocation(showElement
							.getAttributeValue("locationName"));
					ei.setAddress(showElement.getAttributeValue("location"));
					ei.setAvailable("Y".equalsIgnoreCase(showElement
							.getAttributeValue("onsales")) ? true : false);
					ei.setLatitude(Float.parseFloat(showElement
							.getAttributeValue("latitude")));
					ei.setLongitude(Float.parseFloat(showElement
							.getAttributeValue("longitude")));
					ei.setPrice(showElement.getAttributeValue("price"));
					event.getEventInstances().add(ei);
				}
			}

			event.save();
		}
		//ontModel.write(System.out, "TURTLE");
		ontModel.write(new FileWriter("data/culture-event.n3"), "RDF/XML");
	}
}
