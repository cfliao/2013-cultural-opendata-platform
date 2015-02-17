package fcu.opendata.jenabean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import thewebsemantic.Id;
import thewebsemantic.Namespace;
import thewebsemantic.binding.RdfBean;

@Namespace("http://cloud.culture.tw/resources/")
public class Event extends RdfBean<Event> {

	@Id
	private String id;
	private String category;
	private String title; // 活動名稱
	private String producer; // 演出單位
	private String discountInfo;
	private String imageUrl; // 代表圖像
	private String hostingParty;// 主辦單位
	private String associateHostingParty;// /協辦單位
	private String relatedParty;// /協辦單位
	private String sponsor;// 贊助單位
	private String description;// 活動簡介
	private String sourceWebsiteUrl;// 活動網址
	private String sourceWebsite;// 來源網站名稱
	private String bookingWebsiteUrl;// 售票網址
	// private String comment;// 備註
	private Date startDate;// 活動起始日期
	private Date endDate;// 活動結束日期
	private List<EventInstance> eventInstances = new ArrayList<EventInstance>();

	public List<EventInstance> getEventInstances() {
		return eventInstances;
	}

	public void setEventInstances(List<EventInstance> eventInstances) {
		this.eventInstances = eventInstances;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getDiscountInfo() {
		return discountInfo;
	}

	public void setDiscountInfo(String discountInfo) {
		this.discountInfo = discountInfo;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getHostingParty() {
		return hostingParty;
	}

	public void setHostingParty(String hostingParty) {
		this.hostingParty = hostingParty;
	}

	public String getAssociateHostingParty() {
		return associateHostingParty;
	}

	public void setAssociateHostingParty(String associateHostingParty) {
		this.associateHostingParty = associateHostingParty;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSourceWebsiteUrl() {
		return sourceWebsiteUrl;
	}

	public void setSourceWebsiteUrl(String sourceWebsiteUrl) {
		this.sourceWebsiteUrl = sourceWebsiteUrl;
	}

	public String getSourceWebsite() {
		return sourceWebsite;
	}

	public void setSourceWebsite(String sourceWebsite) {
		this.sourceWebsite = sourceWebsite;
	}

	public String getBookingWebsiteUrl() {
		return bookingWebsiteUrl;
	}

	public void setBookingWebsiteUrl(String bookingWebsiteUrl) {
		this.bookingWebsiteUrl = bookingWebsiteUrl;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(String relatedParty) {
		this.relatedParty = relatedParty;
	}

}
