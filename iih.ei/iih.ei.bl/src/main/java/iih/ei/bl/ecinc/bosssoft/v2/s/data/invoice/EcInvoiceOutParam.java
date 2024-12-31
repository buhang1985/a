package iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice;

/**
 * 电子票据开具出参
 * @author ly 2019/12/31
 *
 */
public class EcInvoiceOutParam {

	private String billBatchCode;//电子票据代码
	private String billNo;//电子票据号码
	private String random;//电子票据号码
	private String createTime;//电子票据生成时间
	private String billQRCode;//电子票据二维码图片数据
	private String pictureUrl;//电子票据H5页面URL
	private String pictureNetUrl;//电子票据外网H5页面URL
	
	public String getBillBatchCode() {
		return billBatchCode;
	}
	public void setBillBatchCode(String billBatchCode) {
		this.billBatchCode = billBatchCode;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getRandom() {
		return random;
	}
	public void setRandom(String random) {
		this.random = random;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getBillQRCode() {
		return billQRCode;
	}
	public void setBillQRCode(String billQRCode) {
		this.billQRCode = billQRCode;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public String getPictureNetUrl() {
		return pictureNetUrl;
	}
	public void setPictureNetUrl(String pictureNetUrl) {
		this.pictureNetUrl = pictureNetUrl;
	}
}
