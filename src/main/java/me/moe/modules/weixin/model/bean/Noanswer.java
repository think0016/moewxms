package me.moe.modules.weixin.model.bean;

/**
 * 自动回复配置
 * @author liu
 *
 */
public class Noanswer {
	private String itemtype;
	
	private Integer itemid;

	public Integer getItemid() {
		return itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	public String getItemtype() {
		return itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}
	
	
}
