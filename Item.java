package com.company.jpql;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@NamedEntityGraphs({
		@NamedEntityGraph(
			name = "itemCategoriesGraph",
			attributeNodes = { @NamedAttributeNode("categories") }),
			
		@NamedEntityGraph(
			name = "itemBidsMemberGraph",
			attributeNodes = {
					@NamedAttributeNode(value = "bids", subgraph = "bidsMemberGraph")
			},
			subgraphs = {
					@NamedSubgraph(name = "bidsMemberGraph", 
									attributeNodes = { @NamedAttributeNode("member") } )
			})
})

@NamedQuery(
		name = "getAllItemsBasedOnPrice", 
		query = "SELECT i FROM Item i WHERE i.initialPrice >= :price")


@SqlResultSetMappings({
	@SqlResultSetMapping(
		name="ItemResults",
	    entities=@EntityResult(entityClass=Item.class)),
})

@NamedStoredProcedureQuery(
		name = "ReadName",
		procedureName = "read_name",
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "item_pk", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "item_name", type = String.class)
		}
)

@Entity
@Table(name="items")
public class Item {

	@Id
	@GeneratedValue
	@Column(name="item_id")
	private int id;
	
	private String name;
	private String description;
	private double initialPrice;
	private double reservePrice;
	
	@Temporal(TemporalType.DATE)
	private Date validTill;

	@ManyToMany
	@JoinTable(name="categories_items", 
			joinColumns={@JoinColumn(name="item_id")},
			inverseJoinColumns={@JoinColumn(name="category_id")})
	private Set<Category> categories; //many to many
	
	
	//setting loading tpe to eager - for many ended relationship default loading is lazy
	//eager loadingleads to n+1 problem
	@OneToMany(mappedBy="item", fetch=FetchType.LAZY)
	
	//fetch option specific to hibernate to reduce hits to db for eager fetching..
	//@Fetch(FetchMode.SUBSELECT)
	
	//fetch data in batches of specific size
	//@BatchSize(size=10)
	private Set<Bid> bids; //one to many
		
	public Set<Bid> getBids() {
		return bids == null ? new HashSet<Bid>() : bids;
	}
	public Set<Category> getCategories() {
		return categories == null ? new HashSet<Category>() : categories;
	}
	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public double getInitialPrice() {
		return initialPrice;
	}
	public void setInitialPrice(double initialPrice) {
		this.initialPrice = initialPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getReservePrice() {
		return reservePrice;
	}
	public Date getValidTill() {
		return validTill;
	}
	public void setReservePrice(double reservePrice) {
		this.reservePrice = reservePrice;
	}
	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description="
				+ description + ", initialPrice=" + initialPrice
				+ ", reservePrice=" + reservePrice + ", validTill=" + validTill
				+ "]";
	}
}
