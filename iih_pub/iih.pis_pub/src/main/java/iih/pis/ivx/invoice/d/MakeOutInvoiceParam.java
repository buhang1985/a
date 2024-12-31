package iih.pis.ivx.invoice.d;

public class MakeOutInvoiceParam {
	
	//用来存放下方的二十几个字段(必填)
	private MakeOutInvoiceParam invoiceinfo;

	//用户的openid 用户知道是谁在开票(必填)
	private String wxopenid;
	
	//订单号，企业自己内部的订单号码(必填)
	private String ddh;
	
	//发票请求流水号，唯一识别开票请求的流水号(必填)
	private String fpqqlsh;
	
	//纳税人识别码(必填)
	private String nsrsbh;
	
	//纳税人名称(必填)
	private String nsrmc;
	
	//纳税人地址(必填)
	private String nsrdz;
	
	//纳税人电话(必填)
	private String nsrdh;
	
	//纳税人开户行(必填)
	private String nsrbank;
	
	//纳税人银行账号(必填)
	private String nsrbankid;
	
	//购货方名称(必填)
	private String ghfmc;
	
	//购货方识别号
	private String ghfnsrsbh;
	
	//购货方地址
	private String ghfdz;
	
	//购货方电话
	private String ghfdh;
	
	//购货方开户行
	private String ghfbank;
	
	//购货方银行帐号
	private String ghfbankid;
	
	//开票人(必填)
	private String kpr;
	
	//收款人
	private String skr;
	
	//复核人
	private String fhr;
	
	//价税合计(必填)
	private String jshj;
	
	//合计金额(必填)
	private String hjse;
	
	//备注
	private String bz;
	
	//行业类型 0 商业 1其它
	private String hylx;
	
	//发票行项目数据(必填)
	private InvoiceDetail[] invoicedetail_list;

	public MakeOutInvoiceParam getInvoiceinfo() {
		return invoiceinfo;
	}

	public String getWxopenid() {
		return wxopenid;
	}

	public String getDdh() {
		return ddh;
	}

	public String getFpqqlsh() {
		return fpqqlsh;
	}

	public String getNsrsbh() {
		return nsrsbh;
	}

	public String getNsrmc() {
		return nsrmc;
	}

	public String getNsrdz() {
		return nsrdz;
	}

	public String getNsrdh() {
		return nsrdh;
	}

	public String getNsrbank() {
		return nsrbank;
	}

	public String getNsrbankid() {
		return nsrbankid;
	}

	public String getGhfmc() {
		return ghfmc;
	}

	public String getGhfnsrsbh() {
		return ghfnsrsbh;
	}

	public String getGhfdz() {
		return ghfdz;
	}

	public String getGhfdh() {
		return ghfdh;
	}

	public String getGhfbank() {
		return ghfbank;
	}

	public String getGhfbankid() {
		return ghfbankid;
	}

	public String getKpr() {
		return kpr;
	}

	public String getSkr() {
		return skr;
	}

	public String getFhr() {
		return fhr;
	}

	public String getJshj() {
		return jshj;
	}

	public String getHjse() {
		return hjse;
	}

	public String getBz() {
		return bz;
	}

	public String getHylx() {
		return hylx;
	}

	public InvoiceDetail[] getInvoicedetail_list() {
		return invoicedetail_list;
	}

	public void setInvoiceinfo(MakeOutInvoiceParam invoiceinfo) {
		this.invoiceinfo = invoiceinfo;
	}

	public void setWxopenid(String wxopenid) {
		this.wxopenid = wxopenid;
	}

	public void setDdh(String ddh) {
		this.ddh = ddh;
	}

	public void setFpqqlsh(String fpqqlsh) {
		this.fpqqlsh = fpqqlsh;
	}

	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}

	public void setNsrmc(String nsrmc) {
		this.nsrmc = nsrmc;
	}

	public void setNsrdz(String nsrdz) {
		this.nsrdz = nsrdz;
	}

	public void setNsrdh(String nsrdh) {
		this.nsrdh = nsrdh;
	}

	public void setNsrbank(String nsrbank) {
		this.nsrbank = nsrbank;
	}

	public void setNsrbankid(String nsrbankid) {
		this.nsrbankid = nsrbankid;
	}

	public void setGhfmc(String ghfmc) {
		this.ghfmc = ghfmc;
	}

	public void setGhfnsrsbh(String ghfnsrsbh) {
		this.ghfnsrsbh = ghfnsrsbh;
	}

	public void setGhfdz(String ghfdz) {
		this.ghfdz = ghfdz;
	}

	public void setGhfdh(String ghfdh) {
		this.ghfdh = ghfdh;
	}

	public void setGhfbank(String ghfbank) {
		this.ghfbank = ghfbank;
	}

	public void setGhfbankid(String ghfbankid) {
		this.ghfbankid = ghfbankid;
	}

	public void setKpr(String kpr) {
		this.kpr = kpr;
	}

	public void setSkr(String skr) {
		this.skr = skr;
	}

	public void setFhr(String fhr) {
		this.fhr = fhr;
	}

	public void setJshj(String jshj) {
		this.jshj = jshj;
	}

	public void setHjse(String hjse) {
		this.hjse = hjse;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public void setHylx(String hylx) {
		this.hylx = hylx;
	}

	public void setInvoicedetail_list(InvoiceDetail[] invoicedetail_list) {
		this.invoicedetail_list = invoicedetail_list;
	}
	
}
