package b.bean;

import java.io.Serializable;



public class NewBookBean implements Serializable {
	private String nisbn;
	private String nbassort;
	private String npublishernum;
	private String ntitle;
	private String nauthor;
	private String npublisher;
	private String npubyear;
	private String arrivalyear;

	public NewBookBean(
		String nisbn,
		String nbassort,
		String npublishernum,
	    String ntitle,
	    String nauthor,
	    String npublisher,
	    String npubyear,
	    String arrivalyear){


		this.nisbn = nisbn;
	    this.nbassort = nbassort;
	    this.npublishernum = npublishernum;
	    this.ntitle = ntitle;
	    this.nauthor = nauthor;
	    this.npublisher = npublisher;
	    this.npubyear = npubyear;
	    this.arrivalyear = arrivalyear;

	}

	public NewBookBean(){

	}

	public String getNisbn(){
		return nisbn;
	}

	public void setNisbn(String nisbn){
		this.nisbn = nisbn;
	}

	public String getNbassort(){
		return nbassort;
	}

	public void setNbassort(String nbassort){
		this.nbassort = nbassort;
	}



	public String getNpublishernum(){
		return npublishernum;
	}

	public void setNpublishernum(String npublishernum){
		this.npublishernum = npublishernum;
	}

	public String getNtitle(){
		return ntitle;
	}

	public void setNtitle(String ntitle){
		this.ntitle = ntitle;
	}

	public String getNauthor(){
		return nauthor;
	}

	public void setNauthor(String nauthor){
		this.nauthor = nauthor;
	}


	public String getNpublisher(){
		return npublisher;
	}

	public void setNpublisher(String npublisher){
		this.npublisher = npublisher;
	}

	public String getNpubyear(){
		return npubyear;
	}

	public void setNpubyear(String npubyear){
		this.npubyear = npubyear;
	}

	public String getArrivalyear(){
		return arrivalyear;
	}

	public void setArrivalyear(String arrivalyear){
		this.arrivalyear = arrivalyear;
	}

}