package iih.pe.phm.pepsychology.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pepsychology.d.desc.PePsychologyDODesc;
import java.math.BigDecimal;

/**
 * 体检心理评估 DO数据 
 * 
 */
public class PePsychologyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检心理评估量表主键标识
	public static final String ID_PEPSYCHOLOGY= "Id_pepsychology";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//健康预约单ID
	public static final String ID_PEHMAPPT= "Id_pehmappt";
	//1.头痛 
	public static final String Q1= "Q1";
	//2.神经过敏，心中不踏实
	public static final String Q2= "Q2";
	//3.头脑中有不必要的想法或字句盘旋
	public static final String Q3= "Q3";
	//4.头晕或晕倒
	public static final String Q4= "Q4";
	//5.对异性的兴趣减退
	public static final String Q5= "Q5";
	//6.对旁人责备求全
	public static final String Q6= "Q6";
	//7.感到别人能控制您的思想
	public static final String Q7= "Q7";
	//8.责怪别人制造麻烦
	public static final String Q8= "Q8";
	//9.忘性大
	public static final String Q9= "Q9";
	//10.担心自己的衣饰整齐及仪态的端正
	public static final String Q10= "Q10";
	//11.容易烦恼和激动
	public static final String Q11= "Q11";
	//12.胸痛
	public static final String Q12= "Q12";
	//13.害怕空旷的场所或街道
	public static final String Q13= "Q13";
	//14.感到自己的精力下降，活动减慢
	public static final String Q14= "Q14";
	//15.想结束自己的生命
	public static final String Q15= "Q15";
	//16.听到旁人听不到的声音
	public static final String Q16= "Q16";
	//17.发抖
	public static final String Q17= "Q17";
	//18.感到大多数人都不可信任
	public static final String Q18= "Q18";
	//19.胃口不好
	public static final String Q19= "Q19";
	//20.容易哭泣
	public static final String Q20= "Q20";
	//21.同异性相处时感到害羞不自在
	public static final String Q21= "Q21";
	//22.感到受骗，中了圈套或有人想抓住您
	public static final String Q22= "Q22";
	//23.无缘无故地突然感到害怕
	public static final String Q23= "Q23";
	//24.自己不能控制地大发脾气
	public static final String Q24= "Q24";
	//25.怕单独出门
	public static final String Q25= "Q25";
	//26.经常责怪自己
	public static final String Q26= "Q26";
	//27.腰痛
	public static final String Q27= "Q27";
	//28.感到难以完成任务
	public static final String Q28= "Q28";
	//29.感到孤独
	public static final String Q29= "Q29";
	//30.感到苦闷
	public static final String Q30= "Q30";
	//31.过分担忧
	public static final String Q31= "Q31";
	//32.对事物不感兴趣
	public static final String Q32= "Q32";
	//33.感到害怕
	public static final String Q33= "Q33";
	//34.您的感情容易受到伤害
	public static final String Q34= "Q34";
	//35.旁人能知道您的私下想法
	public static final String Q35= "Q35";
	//36.感到别人不理解您、不同情您
	public static final String Q36= "Q36";
	//37.感到人们对您不友好，不喜欢您
	public static final String Q37= "Q37";
	//38.做事必须做得很慢以保证做得正确
	public static final String Q38= "Q38";
	//39.心跳得很厉害
	public static final String Q39= "Q39";
	//40.恶心或胃部不舒服
	public static final String Q40= "Q40";
	//41.感到比不上他人
	public static final String Q41= "Q41";
	//42.肌肉酸痛
	public static final String Q42= "Q42";
	//43.感到有人在监视您、谈论您
	public static final String Q43= "Q43";
	//44.难以入睡
	public static final String Q44= "Q44";
	//45.做事必须反复检查
	public static final String Q45= "Q45";
	//46.难以做出决定
	public static final String Q46= "Q46";
	//47.怕乘电车、公共汽车、地铁或火车
	public static final String Q47= "Q47";
	//48.呼吸有困难
	public static final String Q48= "Q48";
	//49.一阵阵发冷或发热
	public static final String Q49= "Q49";
	//50.因为感到害怕而避开某些东西、场合或活动
	public static final String Q50= "Q50";
	//51.脑子变空了
	public static final String Q51= "Q51";
	//52.身体发麻或刺痛
	public static final String Q52= "Q52";
	//53.喉咙有梗塞感
	public static final String Q53= "Q53";
	//54.感到前途没有希望
	public static final String Q54= "Q54";
	//55.不能集中注意力
	public static final String Q55= "Q55";
	//56.感到身体的某一部分软弱无力
	public static final String Q56= "Q56";
	//57.感到紧张或容易紧张
	public static final String Q57= "Q57";
	//58.感到手或脚发重
	public static final String Q58= "Q58";
	//59.想到死亡的事
	public static final String Q59= "Q59";
	//60.吃得太多
	public static final String Q60= "Q60";
	//61.当别人看着您或谈论您时感到不自在
	public static final String Q61= "Q61";
	//62.有一些不属于您自己的想法
	public static final String Q62= "Q62";
	//63.有想打人或伤害他人的冲动
	public static final String Q63= "Q63";
	//64.醒得太早
	public static final String Q64= "Q64";
	//65.必须反复洗手、点数
	public static final String Q65= "Q65";
	//66.睡得不稳不深
	public static final String Q66= "Q66";
	//67.有想摔坏或破坏东西的想法
	public static final String Q67= "Q67";
	//68.有一些别人没有的想法 
	public static final String Q68= "Q68";
	//69.感到对别人神经过敏
	public static final String Q69= "Q69";
	//70.在商店或电影院等人多的地方感到不自在
	public static final String Q70= "Q70";
	//71.感到任何事情都很困难
	public static final String Q71= "Q71";
	//72.一阵阵恐惧或惊恐
	public static final String Q72= "Q72";
	//73.感到公共场合吃东西很不舒服
	public static final String Q73= "Q73";
	//74.经常与人争论
	public static final String Q74= "Q74";
	//75.单独一人时神经很紧张
	public static final String Q75= "Q75";
	//76.别人对您的成绩没有做出恰当的评价
	public static final String Q76= "Q76";
	//77.即使和别人在一起也感到孤单
	public static final String Q77= "Q77";
	//78.感到坐立不安心神不定
	public static final String Q78= "Q78";
	//79.感到自己没有什么价值
	public static final String Q79= "Q79";
	//80.感到熟悉的东西变成陌生或不像是真的
	public static final String Q80= "Q80";
	//81.大叫或摔东西
	public static final String Q81= "Q81";
	//82.害怕会在公共场合晕倒
	public static final String Q82= "Q82";
	//83.感到别人想占您的便宜
	public static final String Q83= "Q83";
	//84.为一些有关性的想法而很苦恼
	public static final String Q84= "Q84";
	//85.您认为应该因为自己的过错而受到惩罚
	public static final String Q85= "Q85";
	//85.感到要很快把事情做完
	public static final String Q86= "Q86";
	//87.感到自己的身体有严重问题
	public static final String Q87= "Q87";
	//88.从未感到和其他人很亲近
	public static final String Q88= "Q88";
	//89.感到自己有罪
	public static final String Q89= "Q89";
	//90.感到自己的脑子有毛病
	public static final String Q90= "Q90";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//客户编码
	public static final String CODE_PSN= "Code_psn";
	//姓名
	public static final String NAME_PSN= "Name_psn";
	//预约日期
	public static final String DT_APPT= "Dt_appt";
	//预约号
	public static final String NO_APPT= "No_appt";
	//健康管理状态
	public static final String HMSTATUS= "Hmstatus";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检心理评估量表主键标识
	 * @return String
	 */
	public String getId_pepsychology() {
		return ((String) getAttrVal("Id_pepsychology"));
	}	
	/**
	 * 体检心理评估量表主键标识
	 * @param Id_pepsychology
	 */
	public void setId_pepsychology(String Id_pepsychology) {
		setAttrVal("Id_pepsychology", Id_pepsychology);
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
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 体检客户ID
	 * @return String
	 */
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}	
	/**
	 * 体检客户ID
	 * @param Id_pepsnbinfo
	 */
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	/**
	 * 健康预约单ID
	 * @return String
	 */
	public String getId_pehmappt() {
		return ((String) getAttrVal("Id_pehmappt"));
	}	
	/**
	 * 健康预约单ID
	 * @param Id_pehmappt
	 */
	public void setId_pehmappt(String Id_pehmappt) {
		setAttrVal("Id_pehmappt", Id_pehmappt);
	}
	/**
	 * 1.头痛 
	 * @return Integer
	 */
	public Integer getQ1() {
		return ((Integer) getAttrVal("Q1"));
	}	
	/**
	 * 1.头痛 
	 * @param Q1
	 */
	public void setQ1(Integer Q1) {
		setAttrVal("Q1", Q1);
	}
	/**
	 * 2.神经过敏，心中不踏实
	 * @return Integer
	 */
	public Integer getQ2() {
		return ((Integer) getAttrVal("Q2"));
	}	
	/**
	 * 2.神经过敏，心中不踏实
	 * @param Q2
	 */
	public void setQ2(Integer Q2) {
		setAttrVal("Q2", Q2);
	}
	/**
	 * 3.头脑中有不必要的想法或字句盘旋
	 * @return Integer
	 */
	public Integer getQ3() {
		return ((Integer) getAttrVal("Q3"));
	}	
	/**
	 * 3.头脑中有不必要的想法或字句盘旋
	 * @param Q3
	 */
	public void setQ3(Integer Q3) {
		setAttrVal("Q3", Q3);
	}
	/**
	 * 4.头晕或晕倒
	 * @return Integer
	 */
	public Integer getQ4() {
		return ((Integer) getAttrVal("Q4"));
	}	
	/**
	 * 4.头晕或晕倒
	 * @param Q4
	 */
	public void setQ4(Integer Q4) {
		setAttrVal("Q4", Q4);
	}
	/**
	 * 5.对异性的兴趣减退
	 * @return Integer
	 */
	public Integer getQ5() {
		return ((Integer) getAttrVal("Q5"));
	}	
	/**
	 * 5.对异性的兴趣减退
	 * @param Q5
	 */
	public void setQ5(Integer Q5) {
		setAttrVal("Q5", Q5);
	}
	/**
	 * 6.对旁人责备求全
	 * @return Integer
	 */
	public Integer getQ6() {
		return ((Integer) getAttrVal("Q6"));
	}	
	/**
	 * 6.对旁人责备求全
	 * @param Q6
	 */
	public void setQ6(Integer Q6) {
		setAttrVal("Q6", Q6);
	}
	/**
	 * 7.感到别人能控制您的思想
	 * @return Integer
	 */
	public Integer getQ7() {
		return ((Integer) getAttrVal("Q7"));
	}	
	/**
	 * 7.感到别人能控制您的思想
	 * @param Q7
	 */
	public void setQ7(Integer Q7) {
		setAttrVal("Q7", Q7);
	}
	/**
	 * 8.责怪别人制造麻烦
	 * @return Integer
	 */
	public Integer getQ8() {
		return ((Integer) getAttrVal("Q8"));
	}	
	/**
	 * 8.责怪别人制造麻烦
	 * @param Q8
	 */
	public void setQ8(Integer Q8) {
		setAttrVal("Q8", Q8);
	}
	/**
	 * 9.忘性大
	 * @return Integer
	 */
	public Integer getQ9() {
		return ((Integer) getAttrVal("Q9"));
	}	
	/**
	 * 9.忘性大
	 * @param Q9
	 */
	public void setQ9(Integer Q9) {
		setAttrVal("Q9", Q9);
	}
	/**
	 * 10.担心自己的衣饰整齐及仪态的端正
	 * @return Integer
	 */
	public Integer getQ10() {
		return ((Integer) getAttrVal("Q10"));
	}	
	/**
	 * 10.担心自己的衣饰整齐及仪态的端正
	 * @param Q10
	 */
	public void setQ10(Integer Q10) {
		setAttrVal("Q10", Q10);
	}
	/**
	 * 11.容易烦恼和激动
	 * @return Integer
	 */
	public Integer getQ11() {
		return ((Integer) getAttrVal("Q11"));
	}	
	/**
	 * 11.容易烦恼和激动
	 * @param Q11
	 */
	public void setQ11(Integer Q11) {
		setAttrVal("Q11", Q11);
	}
	/**
	 * 12.胸痛
	 * @return Integer
	 */
	public Integer getQ12() {
		return ((Integer) getAttrVal("Q12"));
	}	
	/**
	 * 12.胸痛
	 * @param Q12
	 */
	public void setQ12(Integer Q12) {
		setAttrVal("Q12", Q12);
	}
	/**
	 * 13.害怕空旷的场所或街道
	 * @return Integer
	 */
	public Integer getQ13() {
		return ((Integer) getAttrVal("Q13"));
	}	
	/**
	 * 13.害怕空旷的场所或街道
	 * @param Q13
	 */
	public void setQ13(Integer Q13) {
		setAttrVal("Q13", Q13);
	}
	/**
	 * 14.感到自己的精力下降，活动减慢
	 * @return Integer
	 */
	public Integer getQ14() {
		return ((Integer) getAttrVal("Q14"));
	}	
	/**
	 * 14.感到自己的精力下降，活动减慢
	 * @param Q14
	 */
	public void setQ14(Integer Q14) {
		setAttrVal("Q14", Q14);
	}
	/**
	 * 15.想结束自己的生命
	 * @return Integer
	 */
	public Integer getQ15() {
		return ((Integer) getAttrVal("Q15"));
	}	
	/**
	 * 15.想结束自己的生命
	 * @param Q15
	 */
	public void setQ15(Integer Q15) {
		setAttrVal("Q15", Q15);
	}
	/**
	 * 16.听到旁人听不到的声音
	 * @return Integer
	 */
	public Integer getQ16() {
		return ((Integer) getAttrVal("Q16"));
	}	
	/**
	 * 16.听到旁人听不到的声音
	 * @param Q16
	 */
	public void setQ16(Integer Q16) {
		setAttrVal("Q16", Q16);
	}
	/**
	 * 17.发抖
	 * @return Integer
	 */
	public Integer getQ17() {
		return ((Integer) getAttrVal("Q17"));
	}	
	/**
	 * 17.发抖
	 * @param Q17
	 */
	public void setQ17(Integer Q17) {
		setAttrVal("Q17", Q17);
	}
	/**
	 * 18.感到大多数人都不可信任
	 * @return Integer
	 */
	public Integer getQ18() {
		return ((Integer) getAttrVal("Q18"));
	}	
	/**
	 * 18.感到大多数人都不可信任
	 * @param Q18
	 */
	public void setQ18(Integer Q18) {
		setAttrVal("Q18", Q18);
	}
	/**
	 * 19.胃口不好
	 * @return Integer
	 */
	public Integer getQ19() {
		return ((Integer) getAttrVal("Q19"));
	}	
	/**
	 * 19.胃口不好
	 * @param Q19
	 */
	public void setQ19(Integer Q19) {
		setAttrVal("Q19", Q19);
	}
	/**
	 * 20.容易哭泣
	 * @return Integer
	 */
	public Integer getQ20() {
		return ((Integer) getAttrVal("Q20"));
	}	
	/**
	 * 20.容易哭泣
	 * @param Q20
	 */
	public void setQ20(Integer Q20) {
		setAttrVal("Q20", Q20);
	}
	/**
	 * 21.同异性相处时感到害羞不自在
	 * @return Integer
	 */
	public Integer getQ21() {
		return ((Integer) getAttrVal("Q21"));
	}	
	/**
	 * 21.同异性相处时感到害羞不自在
	 * @param Q21
	 */
	public void setQ21(Integer Q21) {
		setAttrVal("Q21", Q21);
	}
	/**
	 * 22.感到受骗，中了圈套或有人想抓住您
	 * @return Integer
	 */
	public Integer getQ22() {
		return ((Integer) getAttrVal("Q22"));
	}	
	/**
	 * 22.感到受骗，中了圈套或有人想抓住您
	 * @param Q22
	 */
	public void setQ22(Integer Q22) {
		setAttrVal("Q22", Q22);
	}
	/**
	 * 23.无缘无故地突然感到害怕
	 * @return Integer
	 */
	public Integer getQ23() {
		return ((Integer) getAttrVal("Q23"));
	}	
	/**
	 * 23.无缘无故地突然感到害怕
	 * @param Q23
	 */
	public void setQ23(Integer Q23) {
		setAttrVal("Q23", Q23);
	}
	/**
	 * 24.自己不能控制地大发脾气
	 * @return Integer
	 */
	public Integer getQ24() {
		return ((Integer) getAttrVal("Q24"));
	}	
	/**
	 * 24.自己不能控制地大发脾气
	 * @param Q24
	 */
	public void setQ24(Integer Q24) {
		setAttrVal("Q24", Q24);
	}
	/**
	 * 25.怕单独出门
	 * @return Integer
	 */
	public Integer getQ25() {
		return ((Integer) getAttrVal("Q25"));
	}	
	/**
	 * 25.怕单独出门
	 * @param Q25
	 */
	public void setQ25(Integer Q25) {
		setAttrVal("Q25", Q25);
	}
	/**
	 * 26.经常责怪自己
	 * @return Integer
	 */
	public Integer getQ26() {
		return ((Integer) getAttrVal("Q26"));
	}	
	/**
	 * 26.经常责怪自己
	 * @param Q26
	 */
	public void setQ26(Integer Q26) {
		setAttrVal("Q26", Q26);
	}
	/**
	 * 27.腰痛
	 * @return Integer
	 */
	public Integer getQ27() {
		return ((Integer) getAttrVal("Q27"));
	}	
	/**
	 * 27.腰痛
	 * @param Q27
	 */
	public void setQ27(Integer Q27) {
		setAttrVal("Q27", Q27);
	}
	/**
	 * 28.感到难以完成任务
	 * @return Integer
	 */
	public Integer getQ28() {
		return ((Integer) getAttrVal("Q28"));
	}	
	/**
	 * 28.感到难以完成任务
	 * @param Q28
	 */
	public void setQ28(Integer Q28) {
		setAttrVal("Q28", Q28);
	}
	/**
	 * 29.感到孤独
	 * @return Integer
	 */
	public Integer getQ29() {
		return ((Integer) getAttrVal("Q29"));
	}	
	/**
	 * 29.感到孤独
	 * @param Q29
	 */
	public void setQ29(Integer Q29) {
		setAttrVal("Q29", Q29);
	}
	/**
	 * 30.感到苦闷
	 * @return Integer
	 */
	public Integer getQ30() {
		return ((Integer) getAttrVal("Q30"));
	}	
	/**
	 * 30.感到苦闷
	 * @param Q30
	 */
	public void setQ30(Integer Q30) {
		setAttrVal("Q30", Q30);
	}
	/**
	 * 31.过分担忧
	 * @return Integer
	 */
	public Integer getQ31() {
		return ((Integer) getAttrVal("Q31"));
	}	
	/**
	 * 31.过分担忧
	 * @param Q31
	 */
	public void setQ31(Integer Q31) {
		setAttrVal("Q31", Q31);
	}
	/**
	 * 32.对事物不感兴趣
	 * @return Integer
	 */
	public Integer getQ32() {
		return ((Integer) getAttrVal("Q32"));
	}	
	/**
	 * 32.对事物不感兴趣
	 * @param Q32
	 */
	public void setQ32(Integer Q32) {
		setAttrVal("Q32", Q32);
	}
	/**
	 * 33.感到害怕
	 * @return Integer
	 */
	public Integer getQ33() {
		return ((Integer) getAttrVal("Q33"));
	}	
	/**
	 * 33.感到害怕
	 * @param Q33
	 */
	public void setQ33(Integer Q33) {
		setAttrVal("Q33", Q33);
	}
	/**
	 * 34.您的感情容易受到伤害
	 * @return Integer
	 */
	public Integer getQ34() {
		return ((Integer) getAttrVal("Q34"));
	}	
	/**
	 * 34.您的感情容易受到伤害
	 * @param Q34
	 */
	public void setQ34(Integer Q34) {
		setAttrVal("Q34", Q34);
	}
	/**
	 * 35.旁人能知道您的私下想法
	 * @return Integer
	 */
	public Integer getQ35() {
		return ((Integer) getAttrVal("Q35"));
	}	
	/**
	 * 35.旁人能知道您的私下想法
	 * @param Q35
	 */
	public void setQ35(Integer Q35) {
		setAttrVal("Q35", Q35);
	}
	/**
	 * 36.感到别人不理解您、不同情您
	 * @return Integer
	 */
	public Integer getQ36() {
		return ((Integer) getAttrVal("Q36"));
	}	
	/**
	 * 36.感到别人不理解您、不同情您
	 * @param Q36
	 */
	public void setQ36(Integer Q36) {
		setAttrVal("Q36", Q36);
	}
	/**
	 * 37.感到人们对您不友好，不喜欢您
	 * @return Integer
	 */
	public Integer getQ37() {
		return ((Integer) getAttrVal("Q37"));
	}	
	/**
	 * 37.感到人们对您不友好，不喜欢您
	 * @param Q37
	 */
	public void setQ37(Integer Q37) {
		setAttrVal("Q37", Q37);
	}
	/**
	 * 38.做事必须做得很慢以保证做得正确
	 * @return Integer
	 */
	public Integer getQ38() {
		return ((Integer) getAttrVal("Q38"));
	}	
	/**
	 * 38.做事必须做得很慢以保证做得正确
	 * @param Q38
	 */
	public void setQ38(Integer Q38) {
		setAttrVal("Q38", Q38);
	}
	/**
	 * 39.心跳得很厉害
	 * @return Integer
	 */
	public Integer getQ39() {
		return ((Integer) getAttrVal("Q39"));
	}	
	/**
	 * 39.心跳得很厉害
	 * @param Q39
	 */
	public void setQ39(Integer Q39) {
		setAttrVal("Q39", Q39);
	}
	/**
	 * 40.恶心或胃部不舒服
	 * @return Integer
	 */
	public Integer getQ40() {
		return ((Integer) getAttrVal("Q40"));
	}	
	/**
	 * 40.恶心或胃部不舒服
	 * @param Q40
	 */
	public void setQ40(Integer Q40) {
		setAttrVal("Q40", Q40);
	}
	/**
	 * 41.感到比不上他人
	 * @return Integer
	 */
	public Integer getQ41() {
		return ((Integer) getAttrVal("Q41"));
	}	
	/**
	 * 41.感到比不上他人
	 * @param Q41
	 */
	public void setQ41(Integer Q41) {
		setAttrVal("Q41", Q41);
	}
	/**
	 * 42.肌肉酸痛
	 * @return Integer
	 */
	public Integer getQ42() {
		return ((Integer) getAttrVal("Q42"));
	}	
	/**
	 * 42.肌肉酸痛
	 * @param Q42
	 */
	public void setQ42(Integer Q42) {
		setAttrVal("Q42", Q42);
	}
	/**
	 * 43.感到有人在监视您、谈论您
	 * @return Integer
	 */
	public Integer getQ43() {
		return ((Integer) getAttrVal("Q43"));
	}	
	/**
	 * 43.感到有人在监视您、谈论您
	 * @param Q43
	 */
	public void setQ43(Integer Q43) {
		setAttrVal("Q43", Q43);
	}
	/**
	 * 44.难以入睡
	 * @return Integer
	 */
	public Integer getQ44() {
		return ((Integer) getAttrVal("Q44"));
	}	
	/**
	 * 44.难以入睡
	 * @param Q44
	 */
	public void setQ44(Integer Q44) {
		setAttrVal("Q44", Q44);
	}
	/**
	 * 45.做事必须反复检查
	 * @return Integer
	 */
	public Integer getQ45() {
		return ((Integer) getAttrVal("Q45"));
	}	
	/**
	 * 45.做事必须反复检查
	 * @param Q45
	 */
	public void setQ45(Integer Q45) {
		setAttrVal("Q45", Q45);
	}
	/**
	 * 46.难以做出决定
	 * @return Integer
	 */
	public Integer getQ46() {
		return ((Integer) getAttrVal("Q46"));
	}	
	/**
	 * 46.难以做出决定
	 * @param Q46
	 */
	public void setQ46(Integer Q46) {
		setAttrVal("Q46", Q46);
	}
	/**
	 * 47.怕乘电车、公共汽车、地铁或火车
	 * @return Integer
	 */
	public Integer getQ47() {
		return ((Integer) getAttrVal("Q47"));
	}	
	/**
	 * 47.怕乘电车、公共汽车、地铁或火车
	 * @param Q47
	 */
	public void setQ47(Integer Q47) {
		setAttrVal("Q47", Q47);
	}
	/**
	 * 48.呼吸有困难
	 * @return Integer
	 */
	public Integer getQ48() {
		return ((Integer) getAttrVal("Q48"));
	}	
	/**
	 * 48.呼吸有困难
	 * @param Q48
	 */
	public void setQ48(Integer Q48) {
		setAttrVal("Q48", Q48);
	}
	/**
	 * 49.一阵阵发冷或发热
	 * @return Integer
	 */
	public Integer getQ49() {
		return ((Integer) getAttrVal("Q49"));
	}	
	/**
	 * 49.一阵阵发冷或发热
	 * @param Q49
	 */
	public void setQ49(Integer Q49) {
		setAttrVal("Q49", Q49);
	}
	/**
	 * 50.因为感到害怕而避开某些东西、场合或活动
	 * @return Integer
	 */
	public Integer getQ50() {
		return ((Integer) getAttrVal("Q50"));
	}	
	/**
	 * 50.因为感到害怕而避开某些东西、场合或活动
	 * @param Q50
	 */
	public void setQ50(Integer Q50) {
		setAttrVal("Q50", Q50);
	}
	/**
	 * 51.脑子变空了
	 * @return Integer
	 */
	public Integer getQ51() {
		return ((Integer) getAttrVal("Q51"));
	}	
	/**
	 * 51.脑子变空了
	 * @param Q51
	 */
	public void setQ51(Integer Q51) {
		setAttrVal("Q51", Q51);
	}
	/**
	 * 52.身体发麻或刺痛
	 * @return Integer
	 */
	public Integer getQ52() {
		return ((Integer) getAttrVal("Q52"));
	}	
	/**
	 * 52.身体发麻或刺痛
	 * @param Q52
	 */
	public void setQ52(Integer Q52) {
		setAttrVal("Q52", Q52);
	}
	/**
	 * 53.喉咙有梗塞感
	 * @return Integer
	 */
	public Integer getQ53() {
		return ((Integer) getAttrVal("Q53"));
	}	
	/**
	 * 53.喉咙有梗塞感
	 * @param Q53
	 */
	public void setQ53(Integer Q53) {
		setAttrVal("Q53", Q53);
	}
	/**
	 * 54.感到前途没有希望
	 * @return Integer
	 */
	public Integer getQ54() {
		return ((Integer) getAttrVal("Q54"));
	}	
	/**
	 * 54.感到前途没有希望
	 * @param Q54
	 */
	public void setQ54(Integer Q54) {
		setAttrVal("Q54", Q54);
	}
	/**
	 * 55.不能集中注意力
	 * @return Integer
	 */
	public Integer getQ55() {
		return ((Integer) getAttrVal("Q55"));
	}	
	/**
	 * 55.不能集中注意力
	 * @param Q55
	 */
	public void setQ55(Integer Q55) {
		setAttrVal("Q55", Q55);
	}
	/**
	 * 56.感到身体的某一部分软弱无力
	 * @return Integer
	 */
	public Integer getQ56() {
		return ((Integer) getAttrVal("Q56"));
	}	
	/**
	 * 56.感到身体的某一部分软弱无力
	 * @param Q56
	 */
	public void setQ56(Integer Q56) {
		setAttrVal("Q56", Q56);
	}
	/**
	 * 57.感到紧张或容易紧张
	 * @return Integer
	 */
	public Integer getQ57() {
		return ((Integer) getAttrVal("Q57"));
	}	
	/**
	 * 57.感到紧张或容易紧张
	 * @param Q57
	 */
	public void setQ57(Integer Q57) {
		setAttrVal("Q57", Q57);
	}
	/**
	 * 58.感到手或脚发重
	 * @return Integer
	 */
	public Integer getQ58() {
		return ((Integer) getAttrVal("Q58"));
	}	
	/**
	 * 58.感到手或脚发重
	 * @param Q58
	 */
	public void setQ58(Integer Q58) {
		setAttrVal("Q58", Q58);
	}
	/**
	 * 59.想到死亡的事
	 * @return Integer
	 */
	public Integer getQ59() {
		return ((Integer) getAttrVal("Q59"));
	}	
	/**
	 * 59.想到死亡的事
	 * @param Q59
	 */
	public void setQ59(Integer Q59) {
		setAttrVal("Q59", Q59);
	}
	/**
	 * 60.吃得太多
	 * @return Integer
	 */
	public Integer getQ60() {
		return ((Integer) getAttrVal("Q60"));
	}	
	/**
	 * 60.吃得太多
	 * @param Q60
	 */
	public void setQ60(Integer Q60) {
		setAttrVal("Q60", Q60);
	}
	/**
	 * 61.当别人看着您或谈论您时感到不自在
	 * @return Integer
	 */
	public Integer getQ61() {
		return ((Integer) getAttrVal("Q61"));
	}	
	/**
	 * 61.当别人看着您或谈论您时感到不自在
	 * @param Q61
	 */
	public void setQ61(Integer Q61) {
		setAttrVal("Q61", Q61);
	}
	/**
	 * 62.有一些不属于您自己的想法
	 * @return Integer
	 */
	public Integer getQ62() {
		return ((Integer) getAttrVal("Q62"));
	}	
	/**
	 * 62.有一些不属于您自己的想法
	 * @param Q62
	 */
	public void setQ62(Integer Q62) {
		setAttrVal("Q62", Q62);
	}
	/**
	 * 63.有想打人或伤害他人的冲动
	 * @return Integer
	 */
	public Integer getQ63() {
		return ((Integer) getAttrVal("Q63"));
	}	
	/**
	 * 63.有想打人或伤害他人的冲动
	 * @param Q63
	 */
	public void setQ63(Integer Q63) {
		setAttrVal("Q63", Q63);
	}
	/**
	 * 64.醒得太早
	 * @return Integer
	 */
	public Integer getQ64() {
		return ((Integer) getAttrVal("Q64"));
	}	
	/**
	 * 64.醒得太早
	 * @param Q64
	 */
	public void setQ64(Integer Q64) {
		setAttrVal("Q64", Q64);
	}
	/**
	 * 65.必须反复洗手、点数
	 * @return Integer
	 */
	public Integer getQ65() {
		return ((Integer) getAttrVal("Q65"));
	}	
	/**
	 * 65.必须反复洗手、点数
	 * @param Q65
	 */
	public void setQ65(Integer Q65) {
		setAttrVal("Q65", Q65);
	}
	/**
	 * 66.睡得不稳不深
	 * @return Integer
	 */
	public Integer getQ66() {
		return ((Integer) getAttrVal("Q66"));
	}	
	/**
	 * 66.睡得不稳不深
	 * @param Q66
	 */
	public void setQ66(Integer Q66) {
		setAttrVal("Q66", Q66);
	}
	/**
	 * 67.有想摔坏或破坏东西的想法
	 * @return Integer
	 */
	public Integer getQ67() {
		return ((Integer) getAttrVal("Q67"));
	}	
	/**
	 * 67.有想摔坏或破坏东西的想法
	 * @param Q67
	 */
	public void setQ67(Integer Q67) {
		setAttrVal("Q67", Q67);
	}
	/**
	 * 68.有一些别人没有的想法 
	 * @return Integer
	 */
	public Integer getQ68() {
		return ((Integer) getAttrVal("Q68"));
	}	
	/**
	 * 68.有一些别人没有的想法 
	 * @param Q68
	 */
	public void setQ68(Integer Q68) {
		setAttrVal("Q68", Q68);
	}
	/**
	 * 69.感到对别人神经过敏
	 * @return Integer
	 */
	public Integer getQ69() {
		return ((Integer) getAttrVal("Q69"));
	}	
	/**
	 * 69.感到对别人神经过敏
	 * @param Q69
	 */
	public void setQ69(Integer Q69) {
		setAttrVal("Q69", Q69);
	}
	/**
	 * 70.在商店或电影院等人多的地方感到不自在
	 * @return Integer
	 */
	public Integer getQ70() {
		return ((Integer) getAttrVal("Q70"));
	}	
	/**
	 * 70.在商店或电影院等人多的地方感到不自在
	 * @param Q70
	 */
	public void setQ70(Integer Q70) {
		setAttrVal("Q70", Q70);
	}
	/**
	 * 71.感到任何事情都很困难
	 * @return Integer
	 */
	public Integer getQ71() {
		return ((Integer) getAttrVal("Q71"));
	}	
	/**
	 * 71.感到任何事情都很困难
	 * @param Q71
	 */
	public void setQ71(Integer Q71) {
		setAttrVal("Q71", Q71);
	}
	/**
	 * 72.一阵阵恐惧或惊恐
	 * @return Integer
	 */
	public Integer getQ72() {
		return ((Integer) getAttrVal("Q72"));
	}	
	/**
	 * 72.一阵阵恐惧或惊恐
	 * @param Q72
	 */
	public void setQ72(Integer Q72) {
		setAttrVal("Q72", Q72);
	}
	/**
	 * 73.感到公共场合吃东西很不舒服
	 * @return Integer
	 */
	public Integer getQ73() {
		return ((Integer) getAttrVal("Q73"));
	}	
	/**
	 * 73.感到公共场合吃东西很不舒服
	 * @param Q73
	 */
	public void setQ73(Integer Q73) {
		setAttrVal("Q73", Q73);
	}
	/**
	 * 74.经常与人争论
	 * @return Integer
	 */
	public Integer getQ74() {
		return ((Integer) getAttrVal("Q74"));
	}	
	/**
	 * 74.经常与人争论
	 * @param Q74
	 */
	public void setQ74(Integer Q74) {
		setAttrVal("Q74", Q74);
	}
	/**
	 * 75.单独一人时神经很紧张
	 * @return Integer
	 */
	public Integer getQ75() {
		return ((Integer) getAttrVal("Q75"));
	}	
	/**
	 * 75.单独一人时神经很紧张
	 * @param Q75
	 */
	public void setQ75(Integer Q75) {
		setAttrVal("Q75", Q75);
	}
	/**
	 * 76.别人对您的成绩没有做出恰当的评价
	 * @return Integer
	 */
	public Integer getQ76() {
		return ((Integer) getAttrVal("Q76"));
	}	
	/**
	 * 76.别人对您的成绩没有做出恰当的评价
	 * @param Q76
	 */
	public void setQ76(Integer Q76) {
		setAttrVal("Q76", Q76);
	}
	/**
	 * 77.即使和别人在一起也感到孤单
	 * @return Integer
	 */
	public Integer getQ77() {
		return ((Integer) getAttrVal("Q77"));
	}	
	/**
	 * 77.即使和别人在一起也感到孤单
	 * @param Q77
	 */
	public void setQ77(Integer Q77) {
		setAttrVal("Q77", Q77);
	}
	/**
	 * 78.感到坐立不安心神不定
	 * @return Integer
	 */
	public Integer getQ78() {
		return ((Integer) getAttrVal("Q78"));
	}	
	/**
	 * 78.感到坐立不安心神不定
	 * @param Q78
	 */
	public void setQ78(Integer Q78) {
		setAttrVal("Q78", Q78);
	}
	/**
	 * 79.感到自己没有什么价值
	 * @return Integer
	 */
	public Integer getQ79() {
		return ((Integer) getAttrVal("Q79"));
	}	
	/**
	 * 79.感到自己没有什么价值
	 * @param Q79
	 */
	public void setQ79(Integer Q79) {
		setAttrVal("Q79", Q79);
	}
	/**
	 * 80.感到熟悉的东西变成陌生或不像是真的
	 * @return Integer
	 */
	public Integer getQ80() {
		return ((Integer) getAttrVal("Q80"));
	}	
	/**
	 * 80.感到熟悉的东西变成陌生或不像是真的
	 * @param Q80
	 */
	public void setQ80(Integer Q80) {
		setAttrVal("Q80", Q80);
	}
	/**
	 * 81.大叫或摔东西
	 * @return Integer
	 */
	public Integer getQ81() {
		return ((Integer) getAttrVal("Q81"));
	}	
	/**
	 * 81.大叫或摔东西
	 * @param Q81
	 */
	public void setQ81(Integer Q81) {
		setAttrVal("Q81", Q81);
	}
	/**
	 * 82.害怕会在公共场合晕倒
	 * @return Integer
	 */
	public Integer getQ82() {
		return ((Integer) getAttrVal("Q82"));
	}	
	/**
	 * 82.害怕会在公共场合晕倒
	 * @param Q82
	 */
	public void setQ82(Integer Q82) {
		setAttrVal("Q82", Q82);
	}
	/**
	 * 83.感到别人想占您的便宜
	 * @return Integer
	 */
	public Integer getQ83() {
		return ((Integer) getAttrVal("Q83"));
	}	
	/**
	 * 83.感到别人想占您的便宜
	 * @param Q83
	 */
	public void setQ83(Integer Q83) {
		setAttrVal("Q83", Q83);
	}
	/**
	 * 84.为一些有关性的想法而很苦恼
	 * @return Integer
	 */
	public Integer getQ84() {
		return ((Integer) getAttrVal("Q84"));
	}	
	/**
	 * 84.为一些有关性的想法而很苦恼
	 * @param Q84
	 */
	public void setQ84(Integer Q84) {
		setAttrVal("Q84", Q84);
	}
	/**
	 * 85.您认为应该因为自己的过错而受到惩罚
	 * @return Integer
	 */
	public Integer getQ85() {
		return ((Integer) getAttrVal("Q85"));
	}	
	/**
	 * 85.您认为应该因为自己的过错而受到惩罚
	 * @param Q85
	 */
	public void setQ85(Integer Q85) {
		setAttrVal("Q85", Q85);
	}
	/**
	 * 85.感到要很快把事情做完
	 * @return Integer
	 */
	public Integer getQ86() {
		return ((Integer) getAttrVal("Q86"));
	}	
	/**
	 * 85.感到要很快把事情做完
	 * @param Q86
	 */
	public void setQ86(Integer Q86) {
		setAttrVal("Q86", Q86);
	}
	/**
	 * 87.感到自己的身体有严重问题
	 * @return Integer
	 */
	public Integer getQ87() {
		return ((Integer) getAttrVal("Q87"));
	}	
	/**
	 * 87.感到自己的身体有严重问题
	 * @param Q87
	 */
	public void setQ87(Integer Q87) {
		setAttrVal("Q87", Q87);
	}
	/**
	 * 88.从未感到和其他人很亲近
	 * @return Integer
	 */
	public Integer getQ88() {
		return ((Integer) getAttrVal("Q88"));
	}	
	/**
	 * 88.从未感到和其他人很亲近
	 * @param Q88
	 */
	public void setQ88(Integer Q88) {
		setAttrVal("Q88", Q88);
	}
	/**
	 * 89.感到自己有罪
	 * @return Integer
	 */
	public Integer getQ89() {
		return ((Integer) getAttrVal("Q89"));
	}	
	/**
	 * 89.感到自己有罪
	 * @param Q89
	 */
	public void setQ89(Integer Q89) {
		setAttrVal("Q89", Q89);
	}
	/**
	 * 90.感到自己的脑子有毛病
	 * @return Integer
	 */
	public Integer getQ90() {
		return ((Integer) getAttrVal("Q90"));
	}	
	/**
	 * 90.感到自己的脑子有毛病
	 * @param Q90
	 */
	public void setQ90(Integer Q90) {
		setAttrVal("Q90", Q90);
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
	 * 客户编码
	 * @return String
	 */
	public String getCode_psn() {
		return ((String) getAttrVal("Code_psn"));
	}	
	/**
	 * 客户编码
	 * @param Code_psn
	 */
	public void setCode_psn(String Code_psn) {
		setAttrVal("Code_psn", Code_psn);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	/**
	 * 姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 预约日期
	 * @return FDate
	 */
	public FDate getDt_appt() {
		return ((FDate) getAttrVal("Dt_appt"));
	}	
	/**
	 * 预约日期
	 * @param Dt_appt
	 */
	public void setDt_appt(FDate Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
	}
	/**
	 * 预约号
	 * @return Integer
	 */
	public Integer getNo_appt() {
		return ((Integer) getAttrVal("No_appt"));
	}	
	/**
	 * 预约号
	 * @param No_appt
	 */
	public void setNo_appt(Integer No_appt) {
		setAttrVal("No_appt", No_appt);
	}
	/**
	 * 健康管理状态
	 * @return Integer
	 */
	public Integer getHmstatus() {
		return ((Integer) getAttrVal("Hmstatus"));
	}	
	/**
	 * 健康管理状态
	 * @param Hmstatus
	 */
	public void setHmstatus(Integer Hmstatus) {
		setAttrVal("Hmstatus", Hmstatus);
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
		return "Id_pepsychology";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pepsychology";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PePsychologyDODesc.class);
	}
	
}