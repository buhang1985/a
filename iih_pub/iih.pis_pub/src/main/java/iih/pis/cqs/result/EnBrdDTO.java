package iih.pis.cqs.result;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;
import iih.en.que.board.d.EnBrdConfigDO;

@XmlRootElement(name = "config")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnBrdDTO  extends BaseWsParam implements Serializable  {
	private static final long serialVersionUID = 1L;
	//大屏主键
	private String Id_brd;
	//编码
	private String Code;
	//名称
	private String Name;
	//标题
	private String Title;
	//补充说明
	private String Des;
	//唯一地址
	private String Addr;
	//滚动消息
	private String Msg_roll;
	//启用标识
	private String Fg_active;
	//大屏类型
	private String Eu_brdtpc;
	//叫号次数
	private String Times_call;
	//大屏自身PC
	private String Id_pc;
	//屏幕宽度(像素)
	private String Brd_width;
	//显示块行数
	private String Num_row_block;
	//屏幕高度(像素)
	private String Brd_height;
	//显示块列数
	private String Num_col_block;
	//圆圈直径
	private String Circle_diam;
	//圆圈字号
	private String Circle_font;
	//列表字号
	private String List_font;
	//前面间隔
	private String Front_width;
	//后面间隔
	private String After_width;
	//单列显示
	private String Fg_single;
	//正序排列
	private String Fg_preface;
	//皮肤主题色
	private String Color_skin;
	//大屏样式
	private String Sd_style;
	//计算机工作站编码
	private String Code_pc;
	//计算机工作站名称
	private String Name_pc;
	//显示屏配置
	private EnBrdConfigDO[] enBrdConfigDOs;

	public EnBrdConfigDO[] getEnBrdConfigDOs() {
		return enBrdConfigDOs;
	}
	public void setEnBrdConfigDOs(EnBrdConfigDO[] enBrdConfigDOs) {
		this.enBrdConfigDOs = enBrdConfigDOs;
	}
	public String getId_brd() {
		return Id_brd;
	}
	public void setId_brd(String id_brd) {
		Id_brd = id_brd;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDes() {
		return Des;
	}
	public void setDes(String des) {
		Des = des;
	}
	public String getAddr() {
		return Addr;
	}
	public void setAddr(String addr) {
		Addr = addr;
	}
	public String getMsg_roll() {
		return Msg_roll;
	}
	public void setMsg_roll(String msg_roll) {
		Msg_roll = msg_roll;
	}
	public String getFg_active() {
		return Fg_active;
	}
	public void setFg_active(String fg_active) {
		Fg_active = fg_active;
	}
	public String getEu_brdtpc() {
		return Eu_brdtpc;
	}
	public void setEu_brdtpc(String eu_brdtpc) {
		Eu_brdtpc = eu_brdtpc;
	}
	public String getTimes_call() {
		return Times_call;
	}
	public void setTimes_call(String times_call) {
		Times_call = times_call;
	}
	public String getId_pc() {
		return Id_pc;
	}
	public void setId_pc(String id_pc) {
		Id_pc = id_pc;
	}
	public String getBrd_width() {
		return Brd_width;
	}
	public void setBrd_width(String brd_width) {
		Brd_width = brd_width;
	}
	public String getNum_row_block() {
		return Num_row_block;
	}
	public void setNum_row_block(String num_row_block) {
		Num_row_block = num_row_block;
	}
	public String getBrd_height() {
		return Brd_height;
	}
	public void setBrd_height(String brd_height) {
		Brd_height = brd_height;
	}
	public String getNum_col_block() {
		return Num_col_block;
	}
	public void setNum_col_block(String num_col_block) {
		Num_col_block = num_col_block;
	}
	public String getCircle_diam() {
		return Circle_diam;
	}
	public void setCircle_diam(String circle_diam) {
		Circle_diam = circle_diam;
	}
	public String getCircle_font() {
		return Circle_font;
	}
	public void setCircle_font(String circle_font) {
		Circle_font = circle_font;
	}
	public String getList_font() {
		return List_font;
	}
	public void setList_font(String list_font) {
		List_font = list_font;
	}
	public String getFront_width() {
		return Front_width;
	}
	public void setFront_width(String front_width) {
		Front_width = front_width;
	}
	public String getAfter_width() {
		return After_width;
	}
	public void setAfter_width(String after_width) {
		After_width = after_width;
	}
	public String getFg_single() {
		return Fg_single;
	}
	public void setFg_single(String fg_single) {
		Fg_single = fg_single;
	}
	public String getFg_preface() {
		return Fg_preface;
	}
	public void setFg_preface(String fg_preface) {
		Fg_preface = fg_preface;
	}
	public String getColor_skin() {
		return Color_skin;
	}
	public void setColor_skin(String color_skin) {
		Color_skin = color_skin;
	}
	public String getSd_style() {
		return Sd_style;
	}
	public void setSd_style(String sd_style) {
		Sd_style = sd_style;
	}
	public String getCode_pc() {
		return Code_pc;
	}
	public void setCode_pc(String code_pc) {
		Code_pc = code_pc;
	}
	public String getName_pc() {
		return Name_pc;
	}
	public void setName_pc(String name_pc) {
		Name_pc = name_pc;
	}
	
}
