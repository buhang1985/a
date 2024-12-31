package iih.en.que.board.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.que.board.d.desc.EnBrdDODesc;
import java.math.BigDecimal;

/**
 * 大屏 DO数据 
 * 
 */
public class EnBrdDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//大屏主键
	public static final String ID_BRD= "Id_brd";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//标题
	public static final String TITLE= "Title";
	//补充说明
	public static final String DES= "Des";
	//唯一地址
	public static final String ADDR= "Addr";
	//滚动消息
	public static final String MSG_ROLL= "Msg_roll";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//大屏类型
	public static final String EU_BRDTPC= "Eu_brdtpc";
	//清屏时间1
	public static final String T_CLEAR1= "T_clear1";
	//清屏时间2
	public static final String T_CLEAR2= "T_clear2";
	//清屏时间3
	public static final String T_CLEAR3= "T_clear3";
	//清屏时间4
	public static final String T_CLEAR4= "T_clear4";
	//叫号次数
	public static final String TIMES_CALL= "Times_call";
	//大屏自身PC
	public static final String ID_PC= "Id_pc";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//屏幕宽度(像素)
	public static final String BRD_WIDTH= "Brd_width";
	//显示块行数
	public static final String NUM_ROW_BLOCK= "Num_row_block";
	//屏幕高度(像素)
	public static final String BRD_HEIGHT= "Brd_height";
	//显示块列数
	public static final String NUM_COL_BLOCK= "Num_col_block";
	//圆圈直径
	public static final String CIRCLE_DIAM= "Circle_diam";
	//圆圈字号
	public static final String CIRCLE_FONT= "Circle_font";
	//列表字号
	public static final String LIST_FONT= "List_font";
	//前面间隔
	public static final String FRONT_WIDTH= "Front_width";
	//后面间隔
	public static final String AFTER_WIDTH= "After_width";
	//单列显示
	public static final String FG_SINGLE= "Fg_single";
	//正序排列
	public static final String FG_PREFACE= "Fg_preface";
	//皮肤主题色
	public static final String COLOR_SKIN= "Color_skin";
	//大屏样式
	public static final String SD_STYLE= "Sd_style";
	//是否显示号类
	public static final String FG_SHOWRESTP= "Fg_showrestp";
	//计算机工作站编码
	public static final String CODE_PC= "Code_pc";
	//计算机工作站名称
	public static final String NAME_PC= "Name_pc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 大屏主键
	 * @return String
	 */
	public String getId_brd() {
		return ((String) getAttrVal("Id_brd"));
	}	
	/**
	 * 大屏主键
	 * @param Id_brd
	 */
	public void setId_brd(String Id_brd) {
		setAttrVal("Id_brd", Id_brd);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 标题
	 * @return String
	 */
	public String getTitle() {
		return ((String) getAttrVal("Title"));
	}	
	/**
	 * 标题
	 * @param Title
	 */
	public void setTitle(String Title) {
		setAttrVal("Title", Title);
	}
	/**
	 * 补充说明
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 补充说明
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 唯一地址
	 * @return String
	 */
	public String getAddr() {
		return ((String) getAttrVal("Addr"));
	}	
	/**
	 * 唯一地址
	 * @param Addr
	 */
	public void setAddr(String Addr) {
		setAttrVal("Addr", Addr);
	}
	/**
	 * 滚动消息
	 * @return String
	 */
	public String getMsg_roll() {
		return ((String) getAttrVal("Msg_roll"));
	}	
	/**
	 * 滚动消息
	 * @param Msg_roll
	 */
	public void setMsg_roll(String Msg_roll) {
		setAttrVal("Msg_roll", Msg_roll);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 大屏类型
	 * @return Integer
	 */
	public Integer getEu_brdtpc() {
		return ((Integer) getAttrVal("Eu_brdtpc"));
	}	
	/**
	 * 大屏类型
	 * @param Eu_brdtpc
	 */
	public void setEu_brdtpc(Integer Eu_brdtpc) {
		setAttrVal("Eu_brdtpc", Eu_brdtpc);
	}
	/**
	 * 清屏时间1
	 * @return FTime
	 */
	public FTime getT_clear1() {
		return ((FTime) getAttrVal("T_clear1"));
	}	
	/**
	 * 清屏时间1
	 * @param T_clear1
	 */
	public void setT_clear1(FTime T_clear1) {
		setAttrVal("T_clear1", T_clear1);
	}
	/**
	 * 清屏时间2
	 * @return FTime
	 */
	public FTime getT_clear2() {
		return ((FTime) getAttrVal("T_clear2"));
	}	
	/**
	 * 清屏时间2
	 * @param T_clear2
	 */
	public void setT_clear2(FTime T_clear2) {
		setAttrVal("T_clear2", T_clear2);
	}
	/**
	 * 清屏时间3
	 * @return FTime
	 */
	public FTime getT_clear3() {
		return ((FTime) getAttrVal("T_clear3"));
	}	
	/**
	 * 清屏时间3
	 * @param T_clear3
	 */
	public void setT_clear3(FTime T_clear3) {
		setAttrVal("T_clear3", T_clear3);
	}
	/**
	 * 清屏时间4
	 * @return FTime
	 */
	public FTime getT_clear4() {
		return ((FTime) getAttrVal("T_clear4"));
	}	
	/**
	 * 清屏时间4
	 * @param T_clear4
	 */
	public void setT_clear4(FTime T_clear4) {
		setAttrVal("T_clear4", T_clear4);
	}
	/**
	 * 叫号次数
	 * @return Integer
	 */
	public Integer getTimes_call() {
		return ((Integer) getAttrVal("Times_call"));
	}	
	/**
	 * 叫号次数
	 * @param Times_call
	 */
	public void setTimes_call(Integer Times_call) {
		setAttrVal("Times_call", Times_call);
	}
	/**
	 * 大屏自身PC
	 * @return String
	 */
	public String getId_pc() {
		return ((String) getAttrVal("Id_pc"));
	}	
	/**
	 * 大屏自身PC
	 * @param Id_pc
	 */
	public void setId_pc(String Id_pc) {
		setAttrVal("Id_pc", Id_pc);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 屏幕宽度(像素)
	 * @return Integer
	 */
	public Integer getBrd_width() {
		return ((Integer) getAttrVal("Brd_width"));
	}	
	/**
	 * 屏幕宽度(像素)
	 * @param Brd_width
	 */
	public void setBrd_width(Integer Brd_width) {
		setAttrVal("Brd_width", Brd_width);
	}
	/**
	 * 显示块行数
	 * @return Integer
	 */
	public Integer getNum_row_block() {
		return ((Integer) getAttrVal("Num_row_block"));
	}	
	/**
	 * 显示块行数
	 * @param Num_row_block
	 */
	public void setNum_row_block(Integer Num_row_block) {
		setAttrVal("Num_row_block", Num_row_block);
	}
	/**
	 * 屏幕高度(像素)
	 * @return Integer
	 */
	public Integer getBrd_height() {
		return ((Integer) getAttrVal("Brd_height"));
	}	
	/**
	 * 屏幕高度(像素)
	 * @param Brd_height
	 */
	public void setBrd_height(Integer Brd_height) {
		setAttrVal("Brd_height", Brd_height);
	}
	/**
	 * 显示块列数
	 * @return Integer
	 */
	public Integer getNum_col_block() {
		return ((Integer) getAttrVal("Num_col_block"));
	}	
	/**
	 * 显示块列数
	 * @param Num_col_block
	 */
	public void setNum_col_block(Integer Num_col_block) {
		setAttrVal("Num_col_block", Num_col_block);
	}
	/**
	 * 圆圈直径
	 * @return Integer
	 */
	public Integer getCircle_diam() {
		return ((Integer) getAttrVal("Circle_diam"));
	}	
	/**
	 * 圆圈直径
	 * @param Circle_diam
	 */
	public void setCircle_diam(Integer Circle_diam) {
		setAttrVal("Circle_diam", Circle_diam);
	}
	/**
	 * 圆圈字号
	 * @return Integer
	 */
	public Integer getCircle_font() {
		return ((Integer) getAttrVal("Circle_font"));
	}	
	/**
	 * 圆圈字号
	 * @param Circle_font
	 */
	public void setCircle_font(Integer Circle_font) {
		setAttrVal("Circle_font", Circle_font);
	}
	/**
	 * 列表字号
	 * @return Integer
	 */
	public Integer getList_font() {
		return ((Integer) getAttrVal("List_font"));
	}	
	/**
	 * 列表字号
	 * @param List_font
	 */
	public void setList_font(Integer List_font) {
		setAttrVal("List_font", List_font);
	}
	/**
	 * 前面间隔
	 * @return Integer
	 */
	public Integer getFront_width() {
		return ((Integer) getAttrVal("Front_width"));
	}	
	/**
	 * 前面间隔
	 * @param Front_width
	 */
	public void setFront_width(Integer Front_width) {
		setAttrVal("Front_width", Front_width);
	}
	/**
	 * 后面间隔
	 * @return Integer
	 */
	public Integer getAfter_width() {
		return ((Integer) getAttrVal("After_width"));
	}	
	/**
	 * 后面间隔
	 * @param After_width
	 */
	public void setAfter_width(Integer After_width) {
		setAttrVal("After_width", After_width);
	}
	/**
	 * 单列显示
	 * @return FBoolean
	 */
	public FBoolean getFg_single() {
		return ((FBoolean) getAttrVal("Fg_single"));
	}	
	/**
	 * 单列显示
	 * @param Fg_single
	 */
	public void setFg_single(FBoolean Fg_single) {
		setAttrVal("Fg_single", Fg_single);
	}
	/**
	 * 正序排列
	 * @return FBoolean
	 */
	public FBoolean getFg_preface() {
		return ((FBoolean) getAttrVal("Fg_preface"));
	}	
	/**
	 * 正序排列
	 * @param Fg_preface
	 */
	public void setFg_preface(FBoolean Fg_preface) {
		setAttrVal("Fg_preface", Fg_preface);
	}
	/**
	 * 皮肤主题色
	 * @return String
	 */
	public String getColor_skin() {
		return ((String) getAttrVal("Color_skin"));
	}	
	/**
	 * 皮肤主题色
	 * @param Color_skin
	 */
	public void setColor_skin(String Color_skin) {
		setAttrVal("Color_skin", Color_skin);
	}
	/**
	 * 大屏样式
	 * @return String
	 */
	public String getSd_style() {
		return ((String) getAttrVal("Sd_style"));
	}	
	/**
	 * 大屏样式
	 * @param Sd_style
	 */
	public void setSd_style(String Sd_style) {
		setAttrVal("Sd_style", Sd_style);
	}
	/**
	 * 是否显示号类
	 * @return FBoolean
	 */
	public FBoolean getFg_showrestp() {
		return ((FBoolean) getAttrVal("Fg_showrestp"));
	}	
	/**
	 * 是否显示号类
	 * @param Fg_showrestp
	 */
	public void setFg_showrestp(FBoolean Fg_showrestp) {
		setAttrVal("Fg_showrestp", Fg_showrestp);
	}
	/**
	 * 计算机工作站编码
	 * @return String
	 */
	public String getCode_pc() {
		return ((String) getAttrVal("Code_pc"));
	}	
	/**
	 * 计算机工作站编码
	 * @param Code_pc
	 */
	public void setCode_pc(String Code_pc) {
		setAttrVal("Code_pc", Code_pc);
	}
	/**
	 * 计算机工作站名称
	 * @return String
	 */
	public String getName_pc() {
		return ((String) getAttrVal("Name_pc"));
	}	
	/**
	 * 计算机工作站名称
	 * @param Name_pc
	 */
	public void setName_pc(String Name_pc) {
		setAttrVal("Name_pc", Name_pc);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_brd";
	}
	
	@Override
	public String getTableName() {	  
		return "en_brd";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnBrdDODesc.class);
	}
	
}