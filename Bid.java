package com.company.jpql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*

			DREAM BOOK

		OBSERVING THE THOUGHTS

	- from where these thoughts are coming? - thoughtrons

	60000 thousands
	98% - 2%

	ANS : there would be a gap thought stream


MIND -			WAVE - PARTICLE THEORY

"write down" your dreams   2% - 700 crore

 */
@Entity
@Table(name="bids")
public class Bid {

	@Id @GeneratedValue
	@Column(name="bid_id")
	private int id;
	
	private double amount;

	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item;
	
	@ManyToOne(fetch=FetchType.LAZY) // whenever the bid is loaded, i dont want the member to be loaded
	@JoinColumn(name="member_id")
	private Member member;
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Bid [id=" + id + ", amount=" + amount + "]";
	}
}
