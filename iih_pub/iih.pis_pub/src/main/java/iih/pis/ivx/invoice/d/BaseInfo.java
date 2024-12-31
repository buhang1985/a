package iih.pis.ivx.invoice.d;

/**
 * 发票卡券模板基础信息
 * @author chen.zhao
 * @since 2019/11/06
 *
 */
public class BaseInfo {

	//发票商家 LOGO(必填)
	private String logo_url;
	
	//收款方(显示在列表),上限为 9 个汉字,建议填入商户简称(必填)
	private String title;
	
	//开票平台自定义入口名称,与 custom_url 字段共同使用,长度限制在 5 个汉字内
	private String custom_url_name;
	
	//开票平台自定义入口跳转外链的地址链接 ,发票外跳的链接会带有发票参数,用于标识是从哪张发票跳出的链接
	private String custom_url;
	
	//显示在入口右侧的 tips ，长度限制在 6 个汉字内
	private String custom_url_sub_title;
	
	//营销场景的自定义入口
	private String promotion_url_name;
	
	//入口跳转外链的地址链接，发票外跳的链接会带有发票参数，用于标识是从那张发票跳出的链接
	private String promotion_url;
	
	//显示在入口右侧的 tips ，长度限制在 6 个汉字内
	private String promotion_url_sub_title;

	public String getLogo_url() {
		return logo_url;
	}

	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCustom_url_name() {
		return custom_url_name;
	}

	public void setCustom_url_name(String custom_url_name) {
		this.custom_url_name = custom_url_name;
	}

	public String getCustom_url() {
		return custom_url;
	}

	public void setCustom_url(String custom_url) {
		this.custom_url = custom_url;
	}

	public String getCustom_url_sub_title() {
		return custom_url_sub_title;
	}

	public void setCustom_url_sub_title(String custom_url_sub_title) {
		this.custom_url_sub_title = custom_url_sub_title;
	}

	public String getPromotion_url_name() {
		return promotion_url_name;
	}

	public void setPromotion_url_name(String promotion_url_name) {
		this.promotion_url_name = promotion_url_name;
	}

	public String getPromotion_url() {
		return promotion_url;
	}

	public void setPromotion_url(String promotion_url) {
		this.promotion_url = promotion_url;
	}

	public String getPromotion_url_sub_title() {
		return promotion_url_sub_title;
	}

	public void setPromotion_url_sub_title(String promotion_url_sub_title) {
		this.promotion_url_sub_title = promotion_url_sub_title;
	}
	
}
