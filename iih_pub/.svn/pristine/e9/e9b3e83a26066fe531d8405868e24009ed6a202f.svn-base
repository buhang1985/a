package iih.pe.phm.pesurveycma.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pesurveycma.d.desc.PeSurveyCmaDODesc;
import java.math.BigDecimal;

/**
 * 体检自测问卷 DO数据 
 * 
 */
public class PeSurveyCmaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检自测问卷主键标识
	public static final String ID_PESURVEYCMA= "Id_pesurveycma";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//姓名
	public static final String NAME= "Name";
	//性别
	public static final String SEX= "Sex";
	//出生日期
	public static final String BIRTHDATE= "Birthdate";
	//汉族
	public static final String FG_NATION= "Fg_nation";
	//少数民族
	public static final String NAMTION_MINORITY= "Namtion_minority";
	//出生地
	public static final String BIRTHPLACE= "Birthplace";
	//婚姻状况
	public static final String MARITAL_STATUS= "Marital_status";
	//文化程度
	public static final String EDUCATION= "Education";
	//职业
	public static final String OCCUPATION= "Occupation";
	//医保类别
	public static final String MEDICAL_INSURANCE= "Medical_insurance";
	//电话
	public static final String TEL= "Tel";
	//您父母或兄弟是否患有明确诊断的疾病？
	public static final String Q1= "Q1";
	//请选择疾病名称（可多选）
	public static final String Q1_1= "Q1_1";
	//请确定所患的恶性肿瘤名称
	public static final String Q1_2= "Q1_2";
	//您的父亲是否在 55 岁、母亲在 65 岁之前患有上述疾病吗？
	public static final String Q1_3= "Q1_3";
	//您是否患有明确诊断的疾病或异常？
	public static final String Q2= "Q2";
	//请您确认具体疾病或异常的名称：
	public static final String Q2_1= "Q2_1";
	//请确定您所患的恶性肿瘤名称:
	public static final String Q2_2= "Q2_2";
	//请填写您被诊断患有上述疾病或异常的年龄
	public static final String Q2_3= "Q2_3";
	//您是否出现过过敏？
	public static final String Q3= "Q3";
	//请选择过敏源:
	public static final String Q3_1= "Q3_1";
	//您是否长期服用药物？（连续服用 6 个月以上，平均每日服用一次以上）
	public static final String Q4= "Q4";
	//您长期服用哪些药物？（可多选）
	public static final String Q4_1= "Q4_1";
	//您是否因病进行过手术治疗？
	public static final String Q5= "Q5";
	//请您选择手术的部位？（可多选）
	public static final String Q5_1= "Q5_1";
	//您第一次来月经的年龄：
	public static final String Q6= "Q6";
	//您是否绝经？
	public static final String Q7= "Q7";
	//绝经年龄： 岁
	public static final String Q7_1= "Q7_1";
	//您的结婚年龄：
	public static final String Q8= "Q8";
	//您是否生育过？
	public static final String Q9= "Q9";
	//初产年龄： 岁
	public static final String Q9_1_1= "Q9_1_1";
	//生产 次
	public static final String Q9_1_2= "Q9_1_2";
	//流产总次数 次
	public static final String Q9_1_3= "Q9_1_3";
	//您的孩子是母乳喂养吗？
	public static final String Q9_2= "Q9_2";
	//哺乳时间 月
	public static final String Q9_3= "Q9_3";
	//您是否曾患有妊娠糖尿病？
	public static final String Q9_4= "Q9_4";
	//您是否曾患有妊娠高血压？
	public static final String Q9_5= "Q9_5";
	//您感觉身体总体健康状况如何?
	public static final String Q10= "Q10";
	//您感到疲劳乏力或周身明显不适吗？
	public static final String Q11= "Q11";
	//您视力有下降吗？ 
	public static final String Q12= "Q12";
	//您听力有下降吗？
	public static final String Q13= "Q13";
	//您有鼻出血或浓血鼻涕吗？
	public static final String Q14= "Q14";
	//您出现过吞咽不适、哽噎感吗？
	public static final String Q15= "Q15";
	//您有明显的咳嗽、咳痰吗？
	public static final String Q16= "Q16";
	//您有过咳痰带血或咯血吗？
	public static final String Q17= "Q17";
	//您感到胸痛或心前区憋闷不适吗？
	public static final String Q18= "Q18";
	//您感到有胸闷气喘或呼吸困难吗？
	public static final String Q19= "Q19";
	//您感到低热（体温偏高）吗？
	public static final String Q20= "Q20";
	//您感到头晕或头昏吗？
	public static final String Q21= "Q21";
	//您感到恶心、反酸或上腹部不适吗？
	public static final String Q22= "Q22";
	//您有过食欲不振、消化不良或腹胀吗？
	public static final String Q23= "Q23";
	//您有过不明原因跌倒或晕倒吗？ 
	public static final String Q24= "Q24";
	//您感到明显的手足发麻或刺痛吗？
	public static final String Q25= "Q25";
	//您双下肢水肿吗？
	public static final String Q26= "Q26";
	//您排尿困难吗？ 
	public static final String Q27= "Q27";
	//您有尿频、尿急、尿痛及尿血吗？
	public static final String Q28= "Q28";
	//您有腹泻、腹痛或大便习惯改变（入厕时间、次数、形状等）吗？
	public static final String Q29= "Q29";
	//您出现过柏油样便或便中带血吗？
	public static final String Q30= "Q30";
	//您出现过不明原因的身体消瘦或体重减轻吗？（体重减轻超过原体重的 10%）
	public static final String Q31= "Q31";
	//您是否发现乳房有包块，并伴有胀痛吗（与月经周期无关）
	public static final String Q32= "Q32";
	//您有不明原因的阴道出血、白带异常吗？
	public static final String Q33= "Q33";
	//您身体有过明显的疼痛吗？（外伤除外） 
	public static final String Q34= "Q34";
	//疼痛的部位？
	public static final String Q34_1= "Q34_1";
	//您通常能够按时吃三餐吗？
	public static final String Q35= "Q35";
	//您常暴饮暴食吗？
	public static final String Q36= "Q36";
	//您常吃夜宵吗？
	public static final String Q37= "Q37";
	//您参加请客吃饭（应酬）情况？
	public static final String Q38= "Q38";
	//您的饮食口味？
	public static final String Q39= "Q39";
	//您的饮食偏好？
	public static final String Q40= "Q40";
	//您的主食结构如何？
	public static final String Q41= "Q41";
	//您喝牛奶吗？ 
	public static final String Q42= "Q42";
	//您吃鸡蛋吗？
	public static final String Q43= "Q43";
	//您吃豆类及豆制品吗?
	public static final String Q44= "Q44";
	//您吃水果吗？ 
	public static final String Q45= "Q45";
	//您平均每天吃多少蔬菜？
	public static final String Q46= "Q46";
	//您平均每天吃多少肉（猪、牛、羊、禽）？
	public static final String Q47= "Q47";
	//您吃肥肉吗？
	public static final String Q48= "Q48";
	//您吃动物内脏吗？
	public static final String Q49= "Q49";
	//您吃鱼肉或海鲜吗？
	public static final String Q50= "Q50";
	//您喝咖啡吗？
	public static final String Q51= "Q51";
	//您喝含糖饮料（果汁、可乐等）吗？
	public static final String Q52= "Q52";
	//您吸烟吗？（持续吸烟 1 年以上）
	public static final String Q53= "Q53";
	//您通常每天吸多少支烟？（含戒烟前） 支
	public static final String Q53_1= "Q53_1";
	//,您持续吸烟的年限？（含戒烟前） 年
	public static final String Q53_2= "Q53_2";
	//您戒烟多长时间了？ 年
	public static final String Q53_3= "Q53_3";
	//您喝酒吗？（平均每周饮酒 1 次以上）
	public static final String Q54= "Q54";
	//您一般喝什么酒?
	public static final String Q54_1= "Q54_1";
	//您每周喝几次酒？（含戒酒前） 
	public static final String Q54_2= "Q54_2";
	//您每次喝几两？（1 两相当于 50 ml 白酒，100 ml 红酒，300 ml 啤酒）
	public static final String Q54_3= "Q54_3";
	//您持续喝酒的年限？（含戒酒前） 年
	public static final String Q54_4= "Q54_4";
	//您戒酒多长时间了 年
	public static final String Q54_5= "Q54_5";
	//您参加运动锻炼吗？
	public static final String Q55= "Q55";
	//您常采用的运动锻炼方式：（可多选）
	public static final String Q55_1= "Q55_1";
	//您每周锻炼几次？
	public static final String Q55_2= "Q55_2";
	//您每次锻炼多次时间？ 
	public static final String Q55_3= "Q55_3";
	//您坚持锻炼多少年了？ 年
	public static final String Q55_4= "Q55_4";
	//您工作中的体力强度？
	public static final String Q56= "Q56";
	//您每周工作几天？
	public static final String Q56_1= "Q56_1";
	//您每天平均工作多长时间？ 小时
	public static final String Q56_2= "Q56_2";
	//除工作、学习时间外，您每天坐着（如看电视、上网、打麻将、打牌等）的时间是？
	public static final String Q57= "Q57";
	//您的工作/生活场所经常会接触到哪些有害物质？
	public static final String Q58= "Q58";
	//您感到闷闷不乐，情绪低落吗？
	public static final String Q59= "Q59";
	//您容易情绪激动或生气吗？
	public static final String Q60= "Q60";
	//您感到精神紧张，很难放松吗？
	public static final String Q61= "Q61";
	//您比平常容易紧张和着急吗？
	public static final String Q62= "Q62";
	//您容易发脾气，没有耐性吗？
	public static final String Q63= "Q63";
	//您感到心力枯竭，对人对事缺乏热情吗？
	public static final String Q64= "Q64";
	//您容易焦虑不安、心烦意乱吗？
	public static final String Q65= "Q65";
	//您感觉压抑或沮丧吗？
	public static final String Q66= "Q66";
	//您注意力集中有困难吗？
	public static final String Q67= "Q67";
	//最近 1 个月，您的睡眠如何？
	public static final String Q68= "Q68";
	//您睡眠差的主要表现：
	public static final String Q68_1= "Q68_1";
	//影响您睡眠差的主要原因：
	public static final String Q68_2= "Q68_2";
	//您每天平均睡眠时间：（不等于卧床时间）
	public static final String Q69= "Q69";
	//您多长时间做一次体检？
	public static final String Q70= "Q70";
	//您是否主动获取医疗保健知识？
	public static final String Q71= "Q71";
	//您获取医疗保健知识的途径？
	public static final String Q71_1= "Q71_1";
	//您入厕观察二便（大小便）吗？
	public static final String Q72= "Q72";
	//您自测血压、心率吗？
	public static final String Q73= "Q73";
	//您出差或旅游带常用或急救药品吗？
	public static final String Q74= "Q74";
	//您乘坐私家车或出租车时系安全带吗？
	public static final String Q75= "Q75";
	//您经常晒太阳吗？
	public static final String Q76= "Q76";
	//您认为以下血压值哪个最理想？
	public static final String Q77= "Q77";
	//您认为成年人腋下体温最理想的范围是？
	public static final String Q78= "Q78";
	//您认为安静状态下成年人最理想的脉搏次数是？
	public static final String Q79= "Q79";
	//您认为成年人每天最佳食盐量不要超过多少克？
	public static final String Q80= "Q80";
	//您认为成年人正常体重指数是（体重指数=体重 kg/身高 m  2  ）？
	public static final String Q81= "Q81";
	//您认为成年人正常腰围是？男性：
	public static final String Q82_1= "Q82_1";
	//您认为成年人正常腰围是？女性：
	public static final String Q82_2= "Q82_2";
	//您认为成人空腹血糖正常值是？
	public static final String Q83= "Q83";
	//您认为成人三酰甘油正常值是？
	public static final String Q84= "Q84";
	//您认为成人总胆固醇理想值是？
	public static final String Q85= "Q85";
	//答完该问卷后，您对自己的健康状态感觉如何？
	public static final String Q86= "Q86";
	//您对该健康自测问卷的总体印象是？
	public static final String Q87= "Q87";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//健康管理预约单ID
	public static final String ID_PEHMAPPT= "Id_pehmappt";
	//客户姓名
	public static final String NAME_PSN= "Name_psn";
	//性别编码
	public static final String SD_SEX= "Sd_sex";
	//证件号码
	public static final String IDCODE= "Idcode";
	//出生日期
	public static final String DT_BIRTH= "Dt_birth";
	//编码
	public static final String CODE_SEX= "Code_sex";
	//名称
	public static final String NAME_SEX= "Name_sex";
	//编码
	public static final String CODE_NATION= "Code_nation";
	//名称
	public static final String NAME_NATION= "Name_nation";
	//编码
	public static final String CODE_MAR= "Code_mar";
	//名称
	public static final String NAME_MAR= "Name_mar";
	//编码
	public static final String CODE_EDU= "Code_edu";
	//名称
	public static final String NAME_EDU= "Name_edu";
	//名称
	public static final String NAME_Q1_1= "Name_q1_1";
	//名称
	public static final String NAME_Q1_2= "Name_q1_2";
	//名称
	public static final String NAME_Q2_1= "Name_q2_1";
	//名称
	public static final String NAME_Q2_2= "Name_q2_2";
	//名称
	public static final String NAME_Q3_1= "Name_q3_1";
	//名称
	public static final String NAME_Q4_1= "Name_q4_1";
	//名称
	public static final String NAME_Q5_1= "Name_q5_1";
	//名称
	public static final String NAME_Q10= "Name_q10";
	//名称
	public static final String NAME_Q11= "Name_q11";
	//名称
	public static final String NAME_Q12= "Name_q12";
	//名称
	public static final String NAME_Q13= "Name_q13";
	//名称
	public static final String NAME_Q14= "Name_q14";
	//名称
	public static final String NAME_Q15= "Name_q15";
	//名称
	public static final String NAME_Q16= "Name_q16";
	//名称
	public static final String NAME_Q17= "Name_q17";
	//名称
	public static final String NAME_Q18= "Name_q18";
	//名称
	public static final String NAME_Q19= "Name_q19";
	//名称
	public static final String NAME_Q20= "Name_q20";
	//名称
	public static final String NAME_Q21= "Name_q21";
	//名称
	public static final String NAME_Q22= "Name_q22";
	//名称
	public static final String NAME_Q23= "Name_q23";
	//名称
	public static final String NAME_Q24= "Name_q24";
	//名称
	public static final String NAME_Q25= "Name_q25";
	//名称
	public static final String NAME_Q26= "Name_q26";
	//名称
	public static final String NAME_Q27= "Name_q27";
	//名称
	public static final String NAME_Q28= "Name_q28";
	//名称
	public static final String NAME_Q29= "Name_q29";
	//名称
	public static final String NAME_Q30= "Name_q30";
	//名称
	public static final String NAME_34_1= "Name_34_1";
	//名称
	public static final String NAME_Q35= "Name_q35";
	//名称
	public static final String NAME_Q37= "Name_q37";
	//名称
	public static final String NAME_Q38= "Name_q38";
	//名称
	public static final String NAME_Q39= "Name_q39";
	//名称
	public static final String NAME_Q40= "Name_q40";
	//名称
	public static final String NAME_Q41= "Name_q41";
	//名称
	public static final String NAME_Q42= "Name_q42";
	//名称
	public static final String NAME_Q43= "Name_q43";
	//名称
	public static final String NAME_Q44= "Name_q44";
	//名称
	public static final String NAME_Q45= "Name_q45";
	//名称
	public static final String NAME_Q46= "Name_q46";
	//名称
	public static final String NAME_Q47= "Name_q47";
	//名称
	public static final String NAME_Q48= "Name_q48";
	//名称
	public static final String NAME_Q49= "Name_q49";
	//名称
	public static final String NAME_Q50= "Name_q50";
	//名称
	public static final String NAME_Q51= "Name_q51";
	//名称
	public static final String NAME_Q52= "Name_q52";
	//名称
	public static final String NAME_Q53= "Name_q53";
	//名称
	public static final String NAME_Q54= "Name_q54";
	//名称
	public static final String NAME_Q54_1= "Name_q54_1";
	//名称
	public static final String NAME_Q54_2= "Name_q54_2";
	//名称
	public static final String NAME_Q54_3= "Name_q54_3";
	//名称
	public static final String NAME_Q55= "Name_q55";
	//名称
	public static final String NAME_Q55_1= "Name_q55_1";
	//名称
	public static final String NAME_Q55_2= "Name_q55_2";
	//名称
	public static final String NAME_Q55_3= "Name_q55_3";
	//名称
	public static final String NAME_Q56= "Name_q56";
	//名称
	public static final String NAME_Q56_1= "Name_q56_1";
	//名称
	public static final String NAME_Q57= "Name_q57";
	//名称
	public static final String NAME_Q58= "Name_q58";
	//名称
	public static final String NAME_Q59= "Name_q59";
	//名称
	public static final String NAME_Q60= "Name_q60";
	//名称
	public static final String NAME_Q61= "Name_q61";
	//名称
	public static final String NAME_Q62= "Name_q62";
	//名称
	public static final String NAME_Q63= "Name_q63";
	//名称
	public static final String NAME_Q64= "Name_q64";
	//名称
	public static final String NAME_Q65= "Name_q65";
	//名称
	public static final String NAME_Q66= "Name_q66";
	//名称
	public static final String NAME_Q67= "Name_q67";
	//名称
	public static final String NAME_68= "Name_68";
	//名称
	public static final String NAME_Q68_1= "Name_q68_1";
	//名称
	public static final String NAME_Q68_2= "Name_q68_2";
	//名称
	public static final String NAME_Q69= "Name_q69";
	//名称
	public static final String NAME_Q70= "Name_q70";
	//名称
	public static final String NAME_Q71_1= "Name_q71_1";
	//名称
	public static final String NAME_Q72= "Name_q72";
	//名称
	public static final String NAME_Q73= "Name_q73";
	//名称
	public static final String NAME_Q74= "Name_q74";
	//名称
	public static final String NAME_Q75= "Name_q75";
	//名称
	public static final String NAME_Q76= "Name_q76";
	//名称
	public static final String NAME_Q77= "Name_q77";
	//名称
	public static final String NAME_Q78= "Name_q78";
	//名称
	public static final String NAME_Q79= "Name_q79";
	//名称
	public static final String NAME_Q80= "Name_q80";
	//名称
	public static final String NAME_Q81= "Name_q81";
	//名称
	public static final String NAME_82_1= "Name_82_1";
	//名称
	public static final String NAME_Q82_2= "Name_q82_2";
	//名称
	public static final String NAME_Q83= "Name_q83";
	//名称
	public static final String NAME_Q84= "Name_q84";
	//名称
	public static final String NAME_85= "Name_85";
	//名称
	public static final String NAME_Q86= "Name_q86";
	//名称
	public static final String NAME_Q87= "Name_q87";
	//预约日期
	public static final String DT_APPT= "Dt_appt";
	//预约号
	public static final String NO_APPT= "No_appt";
	//健康管理状态
	public static final String HMSTATUS= "Hmstatus";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检自测问卷主键标识
	 * @return String
	 */
	public String getId_pesurveycma() {
		return ((String) getAttrVal("Id_pesurveycma"));
	}	
	/**
	 * 体检自测问卷主键标识
	 * @param Id_pesurveycma
	 */
	public void setId_pesurveycma(String Id_pesurveycma) {
		setAttrVal("Id_pesurveycma", Id_pesurveycma);
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
	 * 姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}	
	/**
	 * 性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getBirthdate() {
		return ((FDate) getAttrVal("Birthdate"));
	}	
	/**
	 * 出生日期
	 * @param Birthdate
	 */
	public void setBirthdate(FDate Birthdate) {
		setAttrVal("Birthdate", Birthdate);
	}
	/**
	 * 汉族
	 * @return FBoolean
	 */
	public FBoolean getFg_nation() {
		return ((FBoolean) getAttrVal("Fg_nation"));
	}	
	/**
	 * 汉族
	 * @param Fg_nation
	 */
	public void setFg_nation(FBoolean Fg_nation) {
		setAttrVal("Fg_nation", Fg_nation);
	}
	/**
	 * 少数民族
	 * @return String
	 */
	public String getNamtion_minority() {
		return ((String) getAttrVal("Namtion_minority"));
	}	
	/**
	 * 少数民族
	 * @param Namtion_minority
	 */
	public void setNamtion_minority(String Namtion_minority) {
		setAttrVal("Namtion_minority", Namtion_minority);
	}
	/**
	 * 出生地
	 * @return String
	 */
	public String getBirthplace() {
		return ((String) getAttrVal("Birthplace"));
	}	
	/**
	 * 出生地
	 * @param Birthplace
	 */
	public void setBirthplace(String Birthplace) {
		setAttrVal("Birthplace", Birthplace);
	}
	/**
	 * 婚姻状况
	 * @return String
	 */
	public String getMarital_status() {
		return ((String) getAttrVal("Marital_status"));
	}	
	/**
	 * 婚姻状况
	 * @param Marital_status
	 */
	public void setMarital_status(String Marital_status) {
		setAttrVal("Marital_status", Marital_status);
	}
	/**
	 * 文化程度
	 * @return String
	 */
	public String getEducation() {
		return ((String) getAttrVal("Education"));
	}	
	/**
	 * 文化程度
	 * @param Education
	 */
	public void setEducation(String Education) {
		setAttrVal("Education", Education);
	}
	/**
	 * 职业
	 * @return String
	 */
	public String getOccupation() {
		return ((String) getAttrVal("Occupation"));
	}	
	/**
	 * 职业
	 * @param Occupation
	 */
	public void setOccupation(String Occupation) {
		setAttrVal("Occupation", Occupation);
	}
	/**
	 * 医保类别
	 * @return String
	 */
	public String getMedical_insurance() {
		return ((String) getAttrVal("Medical_insurance"));
	}	
	/**
	 * 医保类别
	 * @param Medical_insurance
	 */
	public void setMedical_insurance(String Medical_insurance) {
		setAttrVal("Medical_insurance", Medical_insurance);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	/**
	 * 电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 您父母或兄弟是否患有明确诊断的疾病？
	 * @return FBoolean
	 */
	public FBoolean getQ1() {
		return ((FBoolean) getAttrVal("Q1"));
	}	
	/**
	 * 您父母或兄弟是否患有明确诊断的疾病？
	 * @param Q1
	 */
	public void setQ1(FBoolean Q1) {
		setAttrVal("Q1", Q1);
	}
	/**
	 * 请选择疾病名称（可多选）
	 * @return String
	 */
	public String getQ1_1() {
		return ((String) getAttrVal("Q1_1"));
	}	
	/**
	 * 请选择疾病名称（可多选）
	 * @param Q1_1
	 */
	public void setQ1_1(String Q1_1) {
		setAttrVal("Q1_1", Q1_1);
	}
	/**
	 * 请确定所患的恶性肿瘤名称
	 * @return String
	 */
	public String getQ1_2() {
		return ((String) getAttrVal("Q1_2"));
	}	
	/**
	 * 请确定所患的恶性肿瘤名称
	 * @param Q1_2
	 */
	public void setQ1_2(String Q1_2) {
		setAttrVal("Q1_2", Q1_2);
	}
	/**
	 * 您的父亲是否在 55 岁、母亲在 65 岁之前患有上述疾病吗？
	 * @return FBoolean
	 */
	public FBoolean getQ1_3() {
		return ((FBoolean) getAttrVal("Q1_3"));
	}	
	/**
	 * 您的父亲是否在 55 岁、母亲在 65 岁之前患有上述疾病吗？
	 * @param Q1_3
	 */
	public void setQ1_3(FBoolean Q1_3) {
		setAttrVal("Q1_3", Q1_3);
	}
	/**
	 * 您是否患有明确诊断的疾病或异常？
	 * @return FBoolean
	 */
	public FBoolean getQ2() {
		return ((FBoolean) getAttrVal("Q2"));
	}	
	/**
	 * 您是否患有明确诊断的疾病或异常？
	 * @param Q2
	 */
	public void setQ2(FBoolean Q2) {
		setAttrVal("Q2", Q2);
	}
	/**
	 * 请您确认具体疾病或异常的名称：
	 * @return String
	 */
	public String getQ2_1() {
		return ((String) getAttrVal("Q2_1"));
	}	
	/**
	 * 请您确认具体疾病或异常的名称：
	 * @param Q2_1
	 */
	public void setQ2_1(String Q2_1) {
		setAttrVal("Q2_1", Q2_1);
	}
	/**
	 * 请确定您所患的恶性肿瘤名称:
	 * @return String
	 */
	public String getQ2_2() {
		return ((String) getAttrVal("Q2_2"));
	}	
	/**
	 * 请确定您所患的恶性肿瘤名称:
	 * @param Q2_2
	 */
	public void setQ2_2(String Q2_2) {
		setAttrVal("Q2_2", Q2_2);
	}
	/**
	 * 请填写您被诊断患有上述疾病或异常的年龄
	 * @return Integer
	 */
	public Integer getQ2_3() {
		return ((Integer) getAttrVal("Q2_3"));
	}	
	/**
	 * 请填写您被诊断患有上述疾病或异常的年龄
	 * @param Q2_3
	 */
	public void setQ2_3(Integer Q2_3) {
		setAttrVal("Q2_3", Q2_3);
	}
	/**
	 * 您是否出现过过敏？
	 * @return FBoolean
	 */
	public FBoolean getQ3() {
		return ((FBoolean) getAttrVal("Q3"));
	}	
	/**
	 * 您是否出现过过敏？
	 * @param Q3
	 */
	public void setQ3(FBoolean Q3) {
		setAttrVal("Q3", Q3);
	}
	/**
	 * 请选择过敏源:
	 * @return String
	 */
	public String getQ3_1() {
		return ((String) getAttrVal("Q3_1"));
	}	
	/**
	 * 请选择过敏源:
	 * @param Q3_1
	 */
	public void setQ3_1(String Q3_1) {
		setAttrVal("Q3_1", Q3_1);
	}
	/**
	 * 您是否长期服用药物？（连续服用 6 个月以上，平均每日服用一次以上）
	 * @return FBoolean
	 */
	public FBoolean getQ4() {
		return ((FBoolean) getAttrVal("Q4"));
	}	
	/**
	 * 您是否长期服用药物？（连续服用 6 个月以上，平均每日服用一次以上）
	 * @param Q4
	 */
	public void setQ4(FBoolean Q4) {
		setAttrVal("Q4", Q4);
	}
	/**
	 * 您长期服用哪些药物？（可多选）
	 * @return String
	 */
	public String getQ4_1() {
		return ((String) getAttrVal("Q4_1"));
	}	
	/**
	 * 您长期服用哪些药物？（可多选）
	 * @param Q4_1
	 */
	public void setQ4_1(String Q4_1) {
		setAttrVal("Q4_1", Q4_1);
	}
	/**
	 * 您是否因病进行过手术治疗？
	 * @return FBoolean
	 */
	public FBoolean getQ5() {
		return ((FBoolean) getAttrVal("Q5"));
	}	
	/**
	 * 您是否因病进行过手术治疗？
	 * @param Q5
	 */
	public void setQ5(FBoolean Q5) {
		setAttrVal("Q5", Q5);
	}
	/**
	 * 请您选择手术的部位？（可多选）
	 * @return String
	 */
	public String getQ5_1() {
		return ((String) getAttrVal("Q5_1"));
	}	
	/**
	 * 请您选择手术的部位？（可多选）
	 * @param Q5_1
	 */
	public void setQ5_1(String Q5_1) {
		setAttrVal("Q5_1", Q5_1);
	}
	/**
	 * 您第一次来月经的年龄：
	 * @return Integer
	 */
	public Integer getQ6() {
		return ((Integer) getAttrVal("Q6"));
	}	
	/**
	 * 您第一次来月经的年龄：
	 * @param Q6
	 */
	public void setQ6(Integer Q6) {
		setAttrVal("Q6", Q6);
	}
	/**
	 * 您是否绝经？
	 * @return FBoolean
	 */
	public FBoolean getQ7() {
		return ((FBoolean) getAttrVal("Q7"));
	}	
	/**
	 * 您是否绝经？
	 * @param Q7
	 */
	public void setQ7(FBoolean Q7) {
		setAttrVal("Q7", Q7);
	}
	/**
	 * 绝经年龄： 岁
	 * @return Integer
	 */
	public Integer getQ7_1() {
		return ((Integer) getAttrVal("Q7_1"));
	}	
	/**
	 * 绝经年龄： 岁
	 * @param Q7_1
	 */
	public void setQ7_1(Integer Q7_1) {
		setAttrVal("Q7_1", Q7_1);
	}
	/**
	 * 您的结婚年龄：
	 * @return Integer
	 */
	public Integer getQ8() {
		return ((Integer) getAttrVal("Q8"));
	}	
	/**
	 * 您的结婚年龄：
	 * @param Q8
	 */
	public void setQ8(Integer Q8) {
		setAttrVal("Q8", Q8);
	}
	/**
	 * 您是否生育过？
	 * @return FBoolean
	 */
	public FBoolean getQ9() {
		return ((FBoolean) getAttrVal("Q9"));
	}	
	/**
	 * 您是否生育过？
	 * @param Q9
	 */
	public void setQ9(FBoolean Q9) {
		setAttrVal("Q9", Q9);
	}
	/**
	 * 初产年龄： 岁
	 * @return Integer
	 */
	public Integer getQ9_1_1() {
		return ((Integer) getAttrVal("Q9_1_1"));
	}	
	/**
	 * 初产年龄： 岁
	 * @param Q9_1_1
	 */
	public void setQ9_1_1(Integer Q9_1_1) {
		setAttrVal("Q9_1_1", Q9_1_1);
	}
	/**
	 * 生产 次
	 * @return Integer
	 */
	public Integer getQ9_1_2() {
		return ((Integer) getAttrVal("Q9_1_2"));
	}	
	/**
	 * 生产 次
	 * @param Q9_1_2
	 */
	public void setQ9_1_2(Integer Q9_1_2) {
		setAttrVal("Q9_1_2", Q9_1_2);
	}
	/**
	 * 流产总次数 次
	 * @return Integer
	 */
	public Integer getQ9_1_3() {
		return ((Integer) getAttrVal("Q9_1_3"));
	}	
	/**
	 * 流产总次数 次
	 * @param Q9_1_3
	 */
	public void setQ9_1_3(Integer Q9_1_3) {
		setAttrVal("Q9_1_3", Q9_1_3);
	}
	/**
	 * 您的孩子是母乳喂养吗？
	 * @return FBoolean
	 */
	public FBoolean getQ9_2() {
		return ((FBoolean) getAttrVal("Q9_2"));
	}	
	/**
	 * 您的孩子是母乳喂养吗？
	 * @param Q9_2
	 */
	public void setQ9_2(FBoolean Q9_2) {
		setAttrVal("Q9_2", Q9_2);
	}
	/**
	 * 哺乳时间 月
	 * @return Integer
	 */
	public Integer getQ9_3() {
		return ((Integer) getAttrVal("Q9_3"));
	}	
	/**
	 * 哺乳时间 月
	 * @param Q9_3
	 */
	public void setQ9_3(Integer Q9_3) {
		setAttrVal("Q9_3", Q9_3);
	}
	/**
	 * 您是否曾患有妊娠糖尿病？
	 * @return FBoolean
	 */
	public FBoolean getQ9_4() {
		return ((FBoolean) getAttrVal("Q9_4"));
	}	
	/**
	 * 您是否曾患有妊娠糖尿病？
	 * @param Q9_4
	 */
	public void setQ9_4(FBoolean Q9_4) {
		setAttrVal("Q9_4", Q9_4);
	}
	/**
	 * 您是否曾患有妊娠高血压？
	 * @return FBoolean
	 */
	public FBoolean getQ9_5() {
		return ((FBoolean) getAttrVal("Q9_5"));
	}	
	/**
	 * 您是否曾患有妊娠高血压？
	 * @param Q9_5
	 */
	public void setQ9_5(FBoolean Q9_5) {
		setAttrVal("Q9_5", Q9_5);
	}
	/**
	 * 您感觉身体总体健康状况如何?
	 * @return String
	 */
	public String getQ10() {
		return ((String) getAttrVal("Q10"));
	}	
	/**
	 * 您感觉身体总体健康状况如何?
	 * @param Q10
	 */
	public void setQ10(String Q10) {
		setAttrVal("Q10", Q10);
	}
	/**
	 * 您感到疲劳乏力或周身明显不适吗？
	 * @return String
	 */
	public String getQ11() {
		return ((String) getAttrVal("Q11"));
	}	
	/**
	 * 您感到疲劳乏力或周身明显不适吗？
	 * @param Q11
	 */
	public void setQ11(String Q11) {
		setAttrVal("Q11", Q11);
	}
	/**
	 * 您视力有下降吗？ 
	 * @return String
	 */
	public String getQ12() {
		return ((String) getAttrVal("Q12"));
	}	
	/**
	 * 您视力有下降吗？ 
	 * @param Q12
	 */
	public void setQ12(String Q12) {
		setAttrVal("Q12", Q12);
	}
	/**
	 * 您听力有下降吗？
	 * @return String
	 */
	public String getQ13() {
		return ((String) getAttrVal("Q13"));
	}	
	/**
	 * 您听力有下降吗？
	 * @param Q13
	 */
	public void setQ13(String Q13) {
		setAttrVal("Q13", Q13);
	}
	/**
	 * 您有鼻出血或浓血鼻涕吗？
	 * @return String
	 */
	public String getQ14() {
		return ((String) getAttrVal("Q14"));
	}	
	/**
	 * 您有鼻出血或浓血鼻涕吗？
	 * @param Q14
	 */
	public void setQ14(String Q14) {
		setAttrVal("Q14", Q14);
	}
	/**
	 * 您出现过吞咽不适、哽噎感吗？
	 * @return String
	 */
	public String getQ15() {
		return ((String) getAttrVal("Q15"));
	}	
	/**
	 * 您出现过吞咽不适、哽噎感吗？
	 * @param Q15
	 */
	public void setQ15(String Q15) {
		setAttrVal("Q15", Q15);
	}
	/**
	 * 您有明显的咳嗽、咳痰吗？
	 * @return String
	 */
	public String getQ16() {
		return ((String) getAttrVal("Q16"));
	}	
	/**
	 * 您有明显的咳嗽、咳痰吗？
	 * @param Q16
	 */
	public void setQ16(String Q16) {
		setAttrVal("Q16", Q16);
	}
	/**
	 * 您有过咳痰带血或咯血吗？
	 * @return String
	 */
	public String getQ17() {
		return ((String) getAttrVal("Q17"));
	}	
	/**
	 * 您有过咳痰带血或咯血吗？
	 * @param Q17
	 */
	public void setQ17(String Q17) {
		setAttrVal("Q17", Q17);
	}
	/**
	 * 您感到胸痛或心前区憋闷不适吗？
	 * @return String
	 */
	public String getQ18() {
		return ((String) getAttrVal("Q18"));
	}	
	/**
	 * 您感到胸痛或心前区憋闷不适吗？
	 * @param Q18
	 */
	public void setQ18(String Q18) {
		setAttrVal("Q18", Q18);
	}
	/**
	 * 您感到有胸闷气喘或呼吸困难吗？
	 * @return String
	 */
	public String getQ19() {
		return ((String) getAttrVal("Q19"));
	}	
	/**
	 * 您感到有胸闷气喘或呼吸困难吗？
	 * @param Q19
	 */
	public void setQ19(String Q19) {
		setAttrVal("Q19", Q19);
	}
	/**
	 * 您感到低热（体温偏高）吗？
	 * @return String
	 */
	public String getQ20() {
		return ((String) getAttrVal("Q20"));
	}	
	/**
	 * 您感到低热（体温偏高）吗？
	 * @param Q20
	 */
	public void setQ20(String Q20) {
		setAttrVal("Q20", Q20);
	}
	/**
	 * 您感到头晕或头昏吗？
	 * @return String
	 */
	public String getQ21() {
		return ((String) getAttrVal("Q21"));
	}	
	/**
	 * 您感到头晕或头昏吗？
	 * @param Q21
	 */
	public void setQ21(String Q21) {
		setAttrVal("Q21", Q21);
	}
	/**
	 * 您感到恶心、反酸或上腹部不适吗？
	 * @return String
	 */
	public String getQ22() {
		return ((String) getAttrVal("Q22"));
	}	
	/**
	 * 您感到恶心、反酸或上腹部不适吗？
	 * @param Q22
	 */
	public void setQ22(String Q22) {
		setAttrVal("Q22", Q22);
	}
	/**
	 * 您有过食欲不振、消化不良或腹胀吗？
	 * @return String
	 */
	public String getQ23() {
		return ((String) getAttrVal("Q23"));
	}	
	/**
	 * 您有过食欲不振、消化不良或腹胀吗？
	 * @param Q23
	 */
	public void setQ23(String Q23) {
		setAttrVal("Q23", Q23);
	}
	/**
	 * 您有过不明原因跌倒或晕倒吗？ 
	 * @return String
	 */
	public String getQ24() {
		return ((String) getAttrVal("Q24"));
	}	
	/**
	 * 您有过不明原因跌倒或晕倒吗？ 
	 * @param Q24
	 */
	public void setQ24(String Q24) {
		setAttrVal("Q24", Q24);
	}
	/**
	 * 您感到明显的手足发麻或刺痛吗？
	 * @return String
	 */
	public String getQ25() {
		return ((String) getAttrVal("Q25"));
	}	
	/**
	 * 您感到明显的手足发麻或刺痛吗？
	 * @param Q25
	 */
	public void setQ25(String Q25) {
		setAttrVal("Q25", Q25);
	}
	/**
	 * 您双下肢水肿吗？
	 * @return String
	 */
	public String getQ26() {
		return ((String) getAttrVal("Q26"));
	}	
	/**
	 * 您双下肢水肿吗？
	 * @param Q26
	 */
	public void setQ26(String Q26) {
		setAttrVal("Q26", Q26);
	}
	/**
	 * 您排尿困难吗？ 
	 * @return String
	 */
	public String getQ27() {
		return ((String) getAttrVal("Q27"));
	}	
	/**
	 * 您排尿困难吗？ 
	 * @param Q27
	 */
	public void setQ27(String Q27) {
		setAttrVal("Q27", Q27);
	}
	/**
	 * 您有尿频、尿急、尿痛及尿血吗？
	 * @return String
	 */
	public String getQ28() {
		return ((String) getAttrVal("Q28"));
	}	
	/**
	 * 您有尿频、尿急、尿痛及尿血吗？
	 * @param Q28
	 */
	public void setQ28(String Q28) {
		setAttrVal("Q28", Q28);
	}
	/**
	 * 您有腹泻、腹痛或大便习惯改变（入厕时间、次数、形状等）吗？
	 * @return String
	 */
	public String getQ29() {
		return ((String) getAttrVal("Q29"));
	}	
	/**
	 * 您有腹泻、腹痛或大便习惯改变（入厕时间、次数、形状等）吗？
	 * @param Q29
	 */
	public void setQ29(String Q29) {
		setAttrVal("Q29", Q29);
	}
	/**
	 * 您出现过柏油样便或便中带血吗？
	 * @return String
	 */
	public String getQ30() {
		return ((String) getAttrVal("Q30"));
	}	
	/**
	 * 您出现过柏油样便或便中带血吗？
	 * @param Q30
	 */
	public void setQ30(String Q30) {
		setAttrVal("Q30", Q30);
	}
	/**
	 * 您出现过不明原因的身体消瘦或体重减轻吗？（体重减轻超过原体重的 10%）
	 * @return FBoolean
	 */
	public FBoolean getQ31() {
		return ((FBoolean) getAttrVal("Q31"));
	}	
	/**
	 * 您出现过不明原因的身体消瘦或体重减轻吗？（体重减轻超过原体重的 10%）
	 * @param Q31
	 */
	public void setQ31(FBoolean Q31) {
		setAttrVal("Q31", Q31);
	}
	/**
	 * 您是否发现乳房有包块，并伴有胀痛吗（与月经周期无关）
	 * @return FBoolean
	 */
	public FBoolean getQ32() {
		return ((FBoolean) getAttrVal("Q32"));
	}	
	/**
	 * 您是否发现乳房有包块，并伴有胀痛吗（与月经周期无关）
	 * @param Q32
	 */
	public void setQ32(FBoolean Q32) {
		setAttrVal("Q32", Q32);
	}
	/**
	 * 您有不明原因的阴道出血、白带异常吗？
	 * @return FBoolean
	 */
	public FBoolean getQ33() {
		return ((FBoolean) getAttrVal("Q33"));
	}	
	/**
	 * 您有不明原因的阴道出血、白带异常吗？
	 * @param Q33
	 */
	public void setQ33(FBoolean Q33) {
		setAttrVal("Q33", Q33);
	}
	/**
	 * 您身体有过明显的疼痛吗？（外伤除外） 
	 * @return FBoolean
	 */
	public FBoolean getQ34() {
		return ((FBoolean) getAttrVal("Q34"));
	}	
	/**
	 * 您身体有过明显的疼痛吗？（外伤除外） 
	 * @param Q34
	 */
	public void setQ34(FBoolean Q34) {
		setAttrVal("Q34", Q34);
	}
	/**
	 * 疼痛的部位？
	 * @return String
	 */
	public String getQ34_1() {
		return ((String) getAttrVal("Q34_1"));
	}	
	/**
	 * 疼痛的部位？
	 * @param Q34_1
	 */
	public void setQ34_1(String Q34_1) {
		setAttrVal("Q34_1", Q34_1);
	}
	/**
	 * 您通常能够按时吃三餐吗？
	 * @return String
	 */
	public String getQ35() {
		return ((String) getAttrVal("Q35"));
	}	
	/**
	 * 您通常能够按时吃三餐吗？
	 * @param Q35
	 */
	public void setQ35(String Q35) {
		setAttrVal("Q35", Q35);
	}
	/**
	 * 您常暴饮暴食吗？
	 * @return FBoolean
	 */
	public FBoolean getQ36() {
		return ((FBoolean) getAttrVal("Q36"));
	}	
	/**
	 * 您常暴饮暴食吗？
	 * @param Q36
	 */
	public void setQ36(FBoolean Q36) {
		setAttrVal("Q36", Q36);
	}
	/**
	 * 您常吃夜宵吗？
	 * @return String
	 */
	public String getQ37() {
		return ((String) getAttrVal("Q37"));
	}	
	/**
	 * 您常吃夜宵吗？
	 * @param Q37
	 */
	public void setQ37(String Q37) {
		setAttrVal("Q37", Q37);
	}
	/**
	 * 您参加请客吃饭（应酬）情况？
	 * @return String
	 */
	public String getQ38() {
		return ((String) getAttrVal("Q38"));
	}	
	/**
	 * 您参加请客吃饭（应酬）情况？
	 * @param Q38
	 */
	public void setQ38(String Q38) {
		setAttrVal("Q38", Q38);
	}
	/**
	 * 您的饮食口味？
	 * @return String
	 */
	public String getQ39() {
		return ((String) getAttrVal("Q39"));
	}	
	/**
	 * 您的饮食口味？
	 * @param Q39
	 */
	public void setQ39(String Q39) {
		setAttrVal("Q39", Q39);
	}
	/**
	 * 您的饮食偏好？
	 * @return String
	 */
	public String getQ40() {
		return ((String) getAttrVal("Q40"));
	}	
	/**
	 * 您的饮食偏好？
	 * @param Q40
	 */
	public void setQ40(String Q40) {
		setAttrVal("Q40", Q40);
	}
	/**
	 * 您的主食结构如何？
	 * @return String
	 */
	public String getQ41() {
		return ((String) getAttrVal("Q41"));
	}	
	/**
	 * 您的主食结构如何？
	 * @param Q41
	 */
	public void setQ41(String Q41) {
		setAttrVal("Q41", Q41);
	}
	/**
	 * 您喝牛奶吗？ 
	 * @return String
	 */
	public String getQ42() {
		return ((String) getAttrVal("Q42"));
	}	
	/**
	 * 您喝牛奶吗？ 
	 * @param Q42
	 */
	public void setQ42(String Q42) {
		setAttrVal("Q42", Q42);
	}
	/**
	 * 您吃鸡蛋吗？
	 * @return String
	 */
	public String getQ43() {
		return ((String) getAttrVal("Q43"));
	}	
	/**
	 * 您吃鸡蛋吗？
	 * @param Q43
	 */
	public void setQ43(String Q43) {
		setAttrVal("Q43", Q43);
	}
	/**
	 * 您吃豆类及豆制品吗?
	 * @return String
	 */
	public String getQ44() {
		return ((String) getAttrVal("Q44"));
	}	
	/**
	 * 您吃豆类及豆制品吗?
	 * @param Q44
	 */
	public void setQ44(String Q44) {
		setAttrVal("Q44", Q44);
	}
	/**
	 * 您吃水果吗？ 
	 * @return String
	 */
	public String getQ45() {
		return ((String) getAttrVal("Q45"));
	}	
	/**
	 * 您吃水果吗？ 
	 * @param Q45
	 */
	public void setQ45(String Q45) {
		setAttrVal("Q45", Q45);
	}
	/**
	 * 您平均每天吃多少蔬菜？
	 * @return String
	 */
	public String getQ46() {
		return ((String) getAttrVal("Q46"));
	}	
	/**
	 * 您平均每天吃多少蔬菜？
	 * @param Q46
	 */
	public void setQ46(String Q46) {
		setAttrVal("Q46", Q46);
	}
	/**
	 * 您平均每天吃多少肉（猪、牛、羊、禽）？
	 * @return String
	 */
	public String getQ47() {
		return ((String) getAttrVal("Q47"));
	}	
	/**
	 * 您平均每天吃多少肉（猪、牛、羊、禽）？
	 * @param Q47
	 */
	public void setQ47(String Q47) {
		setAttrVal("Q47", Q47);
	}
	/**
	 * 您吃肥肉吗？
	 * @return String
	 */
	public String getQ48() {
		return ((String) getAttrVal("Q48"));
	}	
	/**
	 * 您吃肥肉吗？
	 * @param Q48
	 */
	public void setQ48(String Q48) {
		setAttrVal("Q48", Q48);
	}
	/**
	 * 您吃动物内脏吗？
	 * @return String
	 */
	public String getQ49() {
		return ((String) getAttrVal("Q49"));
	}	
	/**
	 * 您吃动物内脏吗？
	 * @param Q49
	 */
	public void setQ49(String Q49) {
		setAttrVal("Q49", Q49);
	}
	/**
	 * 您吃鱼肉或海鲜吗？
	 * @return String
	 */
	public String getQ50() {
		return ((String) getAttrVal("Q50"));
	}	
	/**
	 * 您吃鱼肉或海鲜吗？
	 * @param Q50
	 */
	public void setQ50(String Q50) {
		setAttrVal("Q50", Q50);
	}
	/**
	 * 您喝咖啡吗？
	 * @return String
	 */
	public String getQ51() {
		return ((String) getAttrVal("Q51"));
	}	
	/**
	 * 您喝咖啡吗？
	 * @param Q51
	 */
	public void setQ51(String Q51) {
		setAttrVal("Q51", Q51);
	}
	/**
	 * 您喝含糖饮料（果汁、可乐等）吗？
	 * @return String
	 */
	public String getQ52() {
		return ((String) getAttrVal("Q52"));
	}	
	/**
	 * 您喝含糖饮料（果汁、可乐等）吗？
	 * @param Q52
	 */
	public void setQ52(String Q52) {
		setAttrVal("Q52", Q52);
	}
	/**
	 * 您吸烟吗？（持续吸烟 1 年以上）
	 * @return String
	 */
	public String getQ53() {
		return ((String) getAttrVal("Q53"));
	}	
	/**
	 * 您吸烟吗？（持续吸烟 1 年以上）
	 * @param Q53
	 */
	public void setQ53(String Q53) {
		setAttrVal("Q53", Q53);
	}
	/**
	 * 您通常每天吸多少支烟？（含戒烟前） 支
	 * @return Integer
	 */
	public Integer getQ53_1() {
		return ((Integer) getAttrVal("Q53_1"));
	}	
	/**
	 * 您通常每天吸多少支烟？（含戒烟前） 支
	 * @param Q53_1
	 */
	public void setQ53_1(Integer Q53_1) {
		setAttrVal("Q53_1", Q53_1);
	}
	/**
	 * ,您持续吸烟的年限？（含戒烟前） 年
	 * @return Integer
	 */
	public Integer getQ53_2() {
		return ((Integer) getAttrVal("Q53_2"));
	}	
	/**
	 * ,您持续吸烟的年限？（含戒烟前） 年
	 * @param Q53_2
	 */
	public void setQ53_2(Integer Q53_2) {
		setAttrVal("Q53_2", Q53_2);
	}
	/**
	 * 您戒烟多长时间了？ 年
	 * @return Integer
	 */
	public Integer getQ53_3() {
		return ((Integer) getAttrVal("Q53_3"));
	}	
	/**
	 * 您戒烟多长时间了？ 年
	 * @param Q53_3
	 */
	public void setQ53_3(Integer Q53_3) {
		setAttrVal("Q53_3", Q53_3);
	}
	/**
	 * 您喝酒吗？（平均每周饮酒 1 次以上）
	 * @return String
	 */
	public String getQ54() {
		return ((String) getAttrVal("Q54"));
	}	
	/**
	 * 您喝酒吗？（平均每周饮酒 1 次以上）
	 * @param Q54
	 */
	public void setQ54(String Q54) {
		setAttrVal("Q54", Q54);
	}
	/**
	 * 您一般喝什么酒?
	 * @return String
	 */
	public String getQ54_1() {
		return ((String) getAttrVal("Q54_1"));
	}	
	/**
	 * 您一般喝什么酒?
	 * @param Q54_1
	 */
	public void setQ54_1(String Q54_1) {
		setAttrVal("Q54_1", Q54_1);
	}
	/**
	 * 您每周喝几次酒？（含戒酒前） 
	 * @return String
	 */
	public String getQ54_2() {
		return ((String) getAttrVal("Q54_2"));
	}	
	/**
	 * 您每周喝几次酒？（含戒酒前） 
	 * @param Q54_2
	 */
	public void setQ54_2(String Q54_2) {
		setAttrVal("Q54_2", Q54_2);
	}
	/**
	 * 您每次喝几两？（1 两相当于 50 ml 白酒，100 ml 红酒，300 ml 啤酒）
	 * @return String
	 */
	public String getQ54_3() {
		return ((String) getAttrVal("Q54_3"));
	}	
	/**
	 * 您每次喝几两？（1 两相当于 50 ml 白酒，100 ml 红酒，300 ml 啤酒）
	 * @param Q54_3
	 */
	public void setQ54_3(String Q54_3) {
		setAttrVal("Q54_3", Q54_3);
	}
	/**
	 * 您持续喝酒的年限？（含戒酒前） 年
	 * @return Integer
	 */
	public Integer getQ54_4() {
		return ((Integer) getAttrVal("Q54_4"));
	}	
	/**
	 * 您持续喝酒的年限？（含戒酒前） 年
	 * @param Q54_4
	 */
	public void setQ54_4(Integer Q54_4) {
		setAttrVal("Q54_4", Q54_4);
	}
	/**
	 * 您戒酒多长时间了 年
	 * @return Integer
	 */
	public Integer getQ54_5() {
		return ((Integer) getAttrVal("Q54_5"));
	}	
	/**
	 * 您戒酒多长时间了 年
	 * @param Q54_5
	 */
	public void setQ54_5(Integer Q54_5) {
		setAttrVal("Q54_5", Q54_5);
	}
	/**
	 * 您参加运动锻炼吗？
	 * @return String
	 */
	public String getQ55() {
		return ((String) getAttrVal("Q55"));
	}	
	/**
	 * 您参加运动锻炼吗？
	 * @param Q55
	 */
	public void setQ55(String Q55) {
		setAttrVal("Q55", Q55);
	}
	/**
	 * 您常采用的运动锻炼方式：（可多选）
	 * @return String
	 */
	public String getQ55_1() {
		return ((String) getAttrVal("Q55_1"));
	}	
	/**
	 * 您常采用的运动锻炼方式：（可多选）
	 * @param Q55_1
	 */
	public void setQ55_1(String Q55_1) {
		setAttrVal("Q55_1", Q55_1);
	}
	/**
	 * 您每周锻炼几次？
	 * @return String
	 */
	public String getQ55_2() {
		return ((String) getAttrVal("Q55_2"));
	}	
	/**
	 * 您每周锻炼几次？
	 * @param Q55_2
	 */
	public void setQ55_2(String Q55_2) {
		setAttrVal("Q55_2", Q55_2);
	}
	/**
	 * 您每次锻炼多次时间？ 
	 * @return String
	 */
	public String getQ55_3() {
		return ((String) getAttrVal("Q55_3"));
	}	
	/**
	 * 您每次锻炼多次时间？ 
	 * @param Q55_3
	 */
	public void setQ55_3(String Q55_3) {
		setAttrVal("Q55_3", Q55_3);
	}
	/**
	 * 您坚持锻炼多少年了？ 年
	 * @return Integer
	 */
	public Integer getQ55_4() {
		return ((Integer) getAttrVal("Q55_4"));
	}	
	/**
	 * 您坚持锻炼多少年了？ 年
	 * @param Q55_4
	 */
	public void setQ55_4(Integer Q55_4) {
		setAttrVal("Q55_4", Q55_4);
	}
	/**
	 * 您工作中的体力强度？
	 * @return String
	 */
	public String getQ56() {
		return ((String) getAttrVal("Q56"));
	}	
	/**
	 * 您工作中的体力强度？
	 * @param Q56
	 */
	public void setQ56(String Q56) {
		setAttrVal("Q56", Q56);
	}
	/**
	 * 您每周工作几天？
	 * @return String
	 */
	public String getQ56_1() {
		return ((String) getAttrVal("Q56_1"));
	}	
	/**
	 * 您每周工作几天？
	 * @param Q56_1
	 */
	public void setQ56_1(String Q56_1) {
		setAttrVal("Q56_1", Q56_1);
	}
	/**
	 * 您每天平均工作多长时间？ 小时
	 * @return Integer
	 */
	public Integer getQ56_2() {
		return ((Integer) getAttrVal("Q56_2"));
	}	
	/**
	 * 您每天平均工作多长时间？ 小时
	 * @param Q56_2
	 */
	public void setQ56_2(Integer Q56_2) {
		setAttrVal("Q56_2", Q56_2);
	}
	/**
	 * 除工作、学习时间外，您每天坐着（如看电视、上网、打麻将、打牌等）的时间是？
	 * @return String
	 */
	public String getQ57() {
		return ((String) getAttrVal("Q57"));
	}	
	/**
	 * 除工作、学习时间外，您每天坐着（如看电视、上网、打麻将、打牌等）的时间是？
	 * @param Q57
	 */
	public void setQ57(String Q57) {
		setAttrVal("Q57", Q57);
	}
	/**
	 * 您的工作/生活场所经常会接触到哪些有害物质？
	 * @return String
	 */
	public String getQ58() {
		return ((String) getAttrVal("Q58"));
	}	
	/**
	 * 您的工作/生活场所经常会接触到哪些有害物质？
	 * @param Q58
	 */
	public void setQ58(String Q58) {
		setAttrVal("Q58", Q58);
	}
	/**
	 * 您感到闷闷不乐，情绪低落吗？
	 * @return String
	 */
	public String getQ59() {
		return ((String) getAttrVal("Q59"));
	}	
	/**
	 * 您感到闷闷不乐，情绪低落吗？
	 * @param Q59
	 */
	public void setQ59(String Q59) {
		setAttrVal("Q59", Q59);
	}
	/**
	 * 您容易情绪激动或生气吗？
	 * @return String
	 */
	public String getQ60() {
		return ((String) getAttrVal("Q60"));
	}	
	/**
	 * 您容易情绪激动或生气吗？
	 * @param Q60
	 */
	public void setQ60(String Q60) {
		setAttrVal("Q60", Q60);
	}
	/**
	 * 您感到精神紧张，很难放松吗？
	 * @return String
	 */
	public String getQ61() {
		return ((String) getAttrVal("Q61"));
	}	
	/**
	 * 您感到精神紧张，很难放松吗？
	 * @param Q61
	 */
	public void setQ61(String Q61) {
		setAttrVal("Q61", Q61);
	}
	/**
	 * 您比平常容易紧张和着急吗？
	 * @return String
	 */
	public String getQ62() {
		return ((String) getAttrVal("Q62"));
	}	
	/**
	 * 您比平常容易紧张和着急吗？
	 * @param Q62
	 */
	public void setQ62(String Q62) {
		setAttrVal("Q62", Q62);
	}
	/**
	 * 您容易发脾气，没有耐性吗？
	 * @return String
	 */
	public String getQ63() {
		return ((String) getAttrVal("Q63"));
	}	
	/**
	 * 您容易发脾气，没有耐性吗？
	 * @param Q63
	 */
	public void setQ63(String Q63) {
		setAttrVal("Q63", Q63);
	}
	/**
	 * 您感到心力枯竭，对人对事缺乏热情吗？
	 * @return String
	 */
	public String getQ64() {
		return ((String) getAttrVal("Q64"));
	}	
	/**
	 * 您感到心力枯竭，对人对事缺乏热情吗？
	 * @param Q64
	 */
	public void setQ64(String Q64) {
		setAttrVal("Q64", Q64);
	}
	/**
	 * 您容易焦虑不安、心烦意乱吗？
	 * @return String
	 */
	public String getQ65() {
		return ((String) getAttrVal("Q65"));
	}	
	/**
	 * 您容易焦虑不安、心烦意乱吗？
	 * @param Q65
	 */
	public void setQ65(String Q65) {
		setAttrVal("Q65", Q65);
	}
	/**
	 * 您感觉压抑或沮丧吗？
	 * @return String
	 */
	public String getQ66() {
		return ((String) getAttrVal("Q66"));
	}	
	/**
	 * 您感觉压抑或沮丧吗？
	 * @param Q66
	 */
	public void setQ66(String Q66) {
		setAttrVal("Q66", Q66);
	}
	/**
	 * 您注意力集中有困难吗？
	 * @return String
	 */
	public String getQ67() {
		return ((String) getAttrVal("Q67"));
	}	
	/**
	 * 您注意力集中有困难吗？
	 * @param Q67
	 */
	public void setQ67(String Q67) {
		setAttrVal("Q67", Q67);
	}
	/**
	 * 最近 1 个月，您的睡眠如何？
	 * @return String
	 */
	public String getQ68() {
		return ((String) getAttrVal("Q68"));
	}	
	/**
	 * 最近 1 个月，您的睡眠如何？
	 * @param Q68
	 */
	public void setQ68(String Q68) {
		setAttrVal("Q68", Q68);
	}
	/**
	 * 您睡眠差的主要表现：
	 * @return String
	 */
	public String getQ68_1() {
		return ((String) getAttrVal("Q68_1"));
	}	
	/**
	 * 您睡眠差的主要表现：
	 * @param Q68_1
	 */
	public void setQ68_1(String Q68_1) {
		setAttrVal("Q68_1", Q68_1);
	}
	/**
	 * 影响您睡眠差的主要原因：
	 * @return String
	 */
	public String getQ68_2() {
		return ((String) getAttrVal("Q68_2"));
	}	
	/**
	 * 影响您睡眠差的主要原因：
	 * @param Q68_2
	 */
	public void setQ68_2(String Q68_2) {
		setAttrVal("Q68_2", Q68_2);
	}
	/**
	 * 您每天平均睡眠时间：（不等于卧床时间）
	 * @return String
	 */
	public String getQ69() {
		return ((String) getAttrVal("Q69"));
	}	
	/**
	 * 您每天平均睡眠时间：（不等于卧床时间）
	 * @param Q69
	 */
	public void setQ69(String Q69) {
		setAttrVal("Q69", Q69);
	}
	/**
	 * 您多长时间做一次体检？
	 * @return String
	 */
	public String getQ70() {
		return ((String) getAttrVal("Q70"));
	}	
	/**
	 * 您多长时间做一次体检？
	 * @param Q70
	 */
	public void setQ70(String Q70) {
		setAttrVal("Q70", Q70);
	}
	/**
	 * 您是否主动获取医疗保健知识？
	 * @return FBoolean
	 */
	public FBoolean getQ71() {
		return ((FBoolean) getAttrVal("Q71"));
	}	
	/**
	 * 您是否主动获取医疗保健知识？
	 * @param Q71
	 */
	public void setQ71(FBoolean Q71) {
		setAttrVal("Q71", Q71);
	}
	/**
	 * 您获取医疗保健知识的途径？
	 * @return String
	 */
	public String getQ71_1() {
		return ((String) getAttrVal("Q71_1"));
	}	
	/**
	 * 您获取医疗保健知识的途径？
	 * @param Q71_1
	 */
	public void setQ71_1(String Q71_1) {
		setAttrVal("Q71_1", Q71_1);
	}
	/**
	 * 您入厕观察二便（大小便）吗？
	 * @return String
	 */
	public String getQ72() {
		return ((String) getAttrVal("Q72"));
	}	
	/**
	 * 您入厕观察二便（大小便）吗？
	 * @param Q72
	 */
	public void setQ72(String Q72) {
		setAttrVal("Q72", Q72);
	}
	/**
	 * 您自测血压、心率吗？
	 * @return String
	 */
	public String getQ73() {
		return ((String) getAttrVal("Q73"));
	}	
	/**
	 * 您自测血压、心率吗？
	 * @param Q73
	 */
	public void setQ73(String Q73) {
		setAttrVal("Q73", Q73);
	}
	/**
	 * 您出差或旅游带常用或急救药品吗？
	 * @return String
	 */
	public String getQ74() {
		return ((String) getAttrVal("Q74"));
	}	
	/**
	 * 您出差或旅游带常用或急救药品吗？
	 * @param Q74
	 */
	public void setQ74(String Q74) {
		setAttrVal("Q74", Q74);
	}
	/**
	 * 您乘坐私家车或出租车时系安全带吗？
	 * @return String
	 */
	public String getQ75() {
		return ((String) getAttrVal("Q75"));
	}	
	/**
	 * 您乘坐私家车或出租车时系安全带吗？
	 * @param Q75
	 */
	public void setQ75(String Q75) {
		setAttrVal("Q75", Q75);
	}
	/**
	 * 您经常晒太阳吗？
	 * @return String
	 */
	public String getQ76() {
		return ((String) getAttrVal("Q76"));
	}	
	/**
	 * 您经常晒太阳吗？
	 * @param Q76
	 */
	public void setQ76(String Q76) {
		setAttrVal("Q76", Q76);
	}
	/**
	 * 您认为以下血压值哪个最理想？
	 * @return String
	 */
	public String getQ77() {
		return ((String) getAttrVal("Q77"));
	}	
	/**
	 * 您认为以下血压值哪个最理想？
	 * @param Q77
	 */
	public void setQ77(String Q77) {
		setAttrVal("Q77", Q77);
	}
	/**
	 * 您认为成年人腋下体温最理想的范围是？
	 * @return String
	 */
	public String getQ78() {
		return ((String) getAttrVal("Q78"));
	}	
	/**
	 * 您认为成年人腋下体温最理想的范围是？
	 * @param Q78
	 */
	public void setQ78(String Q78) {
		setAttrVal("Q78", Q78);
	}
	/**
	 * 您认为安静状态下成年人最理想的脉搏次数是？
	 * @return String
	 */
	public String getQ79() {
		return ((String) getAttrVal("Q79"));
	}	
	/**
	 * 您认为安静状态下成年人最理想的脉搏次数是？
	 * @param Q79
	 */
	public void setQ79(String Q79) {
		setAttrVal("Q79", Q79);
	}
	/**
	 * 您认为成年人每天最佳食盐量不要超过多少克？
	 * @return String
	 */
	public String getQ80() {
		return ((String) getAttrVal("Q80"));
	}	
	/**
	 * 您认为成年人每天最佳食盐量不要超过多少克？
	 * @param Q80
	 */
	public void setQ80(String Q80) {
		setAttrVal("Q80", Q80);
	}
	/**
	 * 您认为成年人正常体重指数是（体重指数=体重 kg/身高 m  2  ）？
	 * @return String
	 */
	public String getQ81() {
		return ((String) getAttrVal("Q81"));
	}	
	/**
	 * 您认为成年人正常体重指数是（体重指数=体重 kg/身高 m  2  ）？
	 * @param Q81
	 */
	public void setQ81(String Q81) {
		setAttrVal("Q81", Q81);
	}
	/**
	 * 您认为成年人正常腰围是？男性：
	 * @return String
	 */
	public String getQ82_1() {
		return ((String) getAttrVal("Q82_1"));
	}	
	/**
	 * 您认为成年人正常腰围是？男性：
	 * @param Q82_1
	 */
	public void setQ82_1(String Q82_1) {
		setAttrVal("Q82_1", Q82_1);
	}
	/**
	 * 您认为成年人正常腰围是？女性：
	 * @return String
	 */
	public String getQ82_2() {
		return ((String) getAttrVal("Q82_2"));
	}	
	/**
	 * 您认为成年人正常腰围是？女性：
	 * @param Q82_2
	 */
	public void setQ82_2(String Q82_2) {
		setAttrVal("Q82_2", Q82_2);
	}
	/**
	 * 您认为成人空腹血糖正常值是？
	 * @return String
	 */
	public String getQ83() {
		return ((String) getAttrVal("Q83"));
	}	
	/**
	 * 您认为成人空腹血糖正常值是？
	 * @param Q83
	 */
	public void setQ83(String Q83) {
		setAttrVal("Q83", Q83);
	}
	/**
	 * 您认为成人三酰甘油正常值是？
	 * @return String
	 */
	public String getQ84() {
		return ((String) getAttrVal("Q84"));
	}	
	/**
	 * 您认为成人三酰甘油正常值是？
	 * @param Q84
	 */
	public void setQ84(String Q84) {
		setAttrVal("Q84", Q84);
	}
	/**
	 * 您认为成人总胆固醇理想值是？
	 * @return String
	 */
	public String getQ85() {
		return ((String) getAttrVal("Q85"));
	}	
	/**
	 * 您认为成人总胆固醇理想值是？
	 * @param Q85
	 */
	public void setQ85(String Q85) {
		setAttrVal("Q85", Q85);
	}
	/**
	 * 答完该问卷后，您对自己的健康状态感觉如何？
	 * @return String
	 */
	public String getQ86() {
		return ((String) getAttrVal("Q86"));
	}	
	/**
	 * 答完该问卷后，您对自己的健康状态感觉如何？
	 * @param Q86
	 */
	public void setQ86(String Q86) {
		setAttrVal("Q86", Q86);
	}
	/**
	 * 您对该健康自测问卷的总体印象是？
	 * @return String
	 */
	public String getQ87() {
		return ((String) getAttrVal("Q87"));
	}	
	/**
	 * 您对该健康自测问卷的总体印象是？
	 * @param Q87
	 */
	public void setQ87(String Q87) {
		setAttrVal("Q87", Q87);
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
	 * 健康管理预约单ID
	 * @return String
	 */
	public String getId_pehmappt() {
		return ((String) getAttrVal("Id_pehmappt"));
	}	
	/**
	 * 健康管理预约单ID
	 * @param Id_pehmappt
	 */
	public void setId_pehmappt(String Id_pehmappt) {
		setAttrVal("Id_pehmappt", Id_pehmappt);
	}
	/**
	 * 客户姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	/**
	 * 客户姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getIdcode() {
		return ((String) getAttrVal("Idcode"));
	}	
	/**
	 * 证件号码
	 * @param Idcode
	 */
	public void setIdcode(String Idcode) {
		setAttrVal("Idcode", Idcode);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_sex() {
		return ((String) getAttrVal("Code_sex"));
	}	
	/**
	 * 编码
	 * @param Code_sex
	 */
	public void setCode_sex(String Code_sex) {
		setAttrVal("Code_sex", Code_sex);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	/**
	 * 名称
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_nation() {
		return ((String) getAttrVal("Code_nation"));
	}	
	/**
	 * 编码
	 * @param Code_nation
	 */
	public void setCode_nation(String Code_nation) {
		setAttrVal("Code_nation", Code_nation);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}	
	/**
	 * 名称
	 * @param Name_nation
	 */
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_mar() {
		return ((String) getAttrVal("Code_mar"));
	}	
	/**
	 * 编码
	 * @param Code_mar
	 */
	public void setCode_mar(String Code_mar) {
		setAttrVal("Code_mar", Code_mar);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_mar() {
		return ((String) getAttrVal("Name_mar"));
	}	
	/**
	 * 名称
	 * @param Name_mar
	 */
	public void setName_mar(String Name_mar) {
		setAttrVal("Name_mar", Name_mar);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_edu() {
		return ((String) getAttrVal("Code_edu"));
	}	
	/**
	 * 编码
	 * @param Code_edu
	 */
	public void setCode_edu(String Code_edu) {
		setAttrVal("Code_edu", Code_edu);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_edu() {
		return ((String) getAttrVal("Name_edu"));
	}	
	/**
	 * 名称
	 * @param Name_edu
	 */
	public void setName_edu(String Name_edu) {
		setAttrVal("Name_edu", Name_edu);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q1_1() {
		return ((String) getAttrVal("Name_q1_1"));
	}	
	/**
	 * 名称
	 * @param Name_q1_1
	 */
	public void setName_q1_1(String Name_q1_1) {
		setAttrVal("Name_q1_1", Name_q1_1);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q1_2() {
		return ((String) getAttrVal("Name_q1_2"));
	}	
	/**
	 * 名称
	 * @param Name_q1_2
	 */
	public void setName_q1_2(String Name_q1_2) {
		setAttrVal("Name_q1_2", Name_q1_2);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q2_1() {
		return ((String) getAttrVal("Name_q2_1"));
	}	
	/**
	 * 名称
	 * @param Name_q2_1
	 */
	public void setName_q2_1(String Name_q2_1) {
		setAttrVal("Name_q2_1", Name_q2_1);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q2_2() {
		return ((String) getAttrVal("Name_q2_2"));
	}	
	/**
	 * 名称
	 * @param Name_q2_2
	 */
	public void setName_q2_2(String Name_q2_2) {
		setAttrVal("Name_q2_2", Name_q2_2);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q3_1() {
		return ((String) getAttrVal("Name_q3_1"));
	}	
	/**
	 * 名称
	 * @param Name_q3_1
	 */
	public void setName_q3_1(String Name_q3_1) {
		setAttrVal("Name_q3_1", Name_q3_1);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q4_1() {
		return ((String) getAttrVal("Name_q4_1"));
	}	
	/**
	 * 名称
	 * @param Name_q4_1
	 */
	public void setName_q4_1(String Name_q4_1) {
		setAttrVal("Name_q4_1", Name_q4_1);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q5_1() {
		return ((String) getAttrVal("Name_q5_1"));
	}	
	/**
	 * 名称
	 * @param Name_q5_1
	 */
	public void setName_q5_1(String Name_q5_1) {
		setAttrVal("Name_q5_1", Name_q5_1);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q10() {
		return ((String) getAttrVal("Name_q10"));
	}	
	/**
	 * 名称
	 * @param Name_q10
	 */
	public void setName_q10(String Name_q10) {
		setAttrVal("Name_q10", Name_q10);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q11() {
		return ((String) getAttrVal("Name_q11"));
	}	
	/**
	 * 名称
	 * @param Name_q11
	 */
	public void setName_q11(String Name_q11) {
		setAttrVal("Name_q11", Name_q11);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q12() {
		return ((String) getAttrVal("Name_q12"));
	}	
	/**
	 * 名称
	 * @param Name_q12
	 */
	public void setName_q12(String Name_q12) {
		setAttrVal("Name_q12", Name_q12);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q13() {
		return ((String) getAttrVal("Name_q13"));
	}	
	/**
	 * 名称
	 * @param Name_q13
	 */
	public void setName_q13(String Name_q13) {
		setAttrVal("Name_q13", Name_q13);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q14() {
		return ((String) getAttrVal("Name_q14"));
	}	
	/**
	 * 名称
	 * @param Name_q14
	 */
	public void setName_q14(String Name_q14) {
		setAttrVal("Name_q14", Name_q14);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q15() {
		return ((String) getAttrVal("Name_q15"));
	}	
	/**
	 * 名称
	 * @param Name_q15
	 */
	public void setName_q15(String Name_q15) {
		setAttrVal("Name_q15", Name_q15);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q16() {
		return ((String) getAttrVal("Name_q16"));
	}	
	/**
	 * 名称
	 * @param Name_q16
	 */
	public void setName_q16(String Name_q16) {
		setAttrVal("Name_q16", Name_q16);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q17() {
		return ((String) getAttrVal("Name_q17"));
	}	
	/**
	 * 名称
	 * @param Name_q17
	 */
	public void setName_q17(String Name_q17) {
		setAttrVal("Name_q17", Name_q17);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q18() {
		return ((String) getAttrVal("Name_q18"));
	}	
	/**
	 * 名称
	 * @param Name_q18
	 */
	public void setName_q18(String Name_q18) {
		setAttrVal("Name_q18", Name_q18);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q19() {
		return ((String) getAttrVal("Name_q19"));
	}	
	/**
	 * 名称
	 * @param Name_q19
	 */
	public void setName_q19(String Name_q19) {
		setAttrVal("Name_q19", Name_q19);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q20() {
		return ((String) getAttrVal("Name_q20"));
	}	
	/**
	 * 名称
	 * @param Name_q20
	 */
	public void setName_q20(String Name_q20) {
		setAttrVal("Name_q20", Name_q20);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q21() {
		return ((String) getAttrVal("Name_q21"));
	}	
	/**
	 * 名称
	 * @param Name_q21
	 */
	public void setName_q21(String Name_q21) {
		setAttrVal("Name_q21", Name_q21);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q22() {
		return ((String) getAttrVal("Name_q22"));
	}	
	/**
	 * 名称
	 * @param Name_q22
	 */
	public void setName_q22(String Name_q22) {
		setAttrVal("Name_q22", Name_q22);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q23() {
		return ((String) getAttrVal("Name_q23"));
	}	
	/**
	 * 名称
	 * @param Name_q23
	 */
	public void setName_q23(String Name_q23) {
		setAttrVal("Name_q23", Name_q23);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q24() {
		return ((String) getAttrVal("Name_q24"));
	}	
	/**
	 * 名称
	 * @param Name_q24
	 */
	public void setName_q24(String Name_q24) {
		setAttrVal("Name_q24", Name_q24);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q25() {
		return ((String) getAttrVal("Name_q25"));
	}	
	/**
	 * 名称
	 * @param Name_q25
	 */
	public void setName_q25(String Name_q25) {
		setAttrVal("Name_q25", Name_q25);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q26() {
		return ((String) getAttrVal("Name_q26"));
	}	
	/**
	 * 名称
	 * @param Name_q26
	 */
	public void setName_q26(String Name_q26) {
		setAttrVal("Name_q26", Name_q26);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q27() {
		return ((String) getAttrVal("Name_q27"));
	}	
	/**
	 * 名称
	 * @param Name_q27
	 */
	public void setName_q27(String Name_q27) {
		setAttrVal("Name_q27", Name_q27);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q28() {
		return ((String) getAttrVal("Name_q28"));
	}	
	/**
	 * 名称
	 * @param Name_q28
	 */
	public void setName_q28(String Name_q28) {
		setAttrVal("Name_q28", Name_q28);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q29() {
		return ((String) getAttrVal("Name_q29"));
	}	
	/**
	 * 名称
	 * @param Name_q29
	 */
	public void setName_q29(String Name_q29) {
		setAttrVal("Name_q29", Name_q29);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q30() {
		return ((String) getAttrVal("Name_q30"));
	}	
	/**
	 * 名称
	 * @param Name_q30
	 */
	public void setName_q30(String Name_q30) {
		setAttrVal("Name_q30", Name_q30);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_34_1() {
		return ((String) getAttrVal("Name_34_1"));
	}	
	/**
	 * 名称
	 * @param Name_34_1
	 */
	public void setName_34_1(String Name_34_1) {
		setAttrVal("Name_34_1", Name_34_1);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q35() {
		return ((String) getAttrVal("Name_q35"));
	}	
	/**
	 * 名称
	 * @param Name_q35
	 */
	public void setName_q35(String Name_q35) {
		setAttrVal("Name_q35", Name_q35);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q37() {
		return ((String) getAttrVal("Name_q37"));
	}	
	/**
	 * 名称
	 * @param Name_q37
	 */
	public void setName_q37(String Name_q37) {
		setAttrVal("Name_q37", Name_q37);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q38() {
		return ((String) getAttrVal("Name_q38"));
	}	
	/**
	 * 名称
	 * @param Name_q38
	 */
	public void setName_q38(String Name_q38) {
		setAttrVal("Name_q38", Name_q38);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q39() {
		return ((String) getAttrVal("Name_q39"));
	}	
	/**
	 * 名称
	 * @param Name_q39
	 */
	public void setName_q39(String Name_q39) {
		setAttrVal("Name_q39", Name_q39);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q40() {
		return ((String) getAttrVal("Name_q40"));
	}	
	/**
	 * 名称
	 * @param Name_q40
	 */
	public void setName_q40(String Name_q40) {
		setAttrVal("Name_q40", Name_q40);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q41() {
		return ((String) getAttrVal("Name_q41"));
	}	
	/**
	 * 名称
	 * @param Name_q41
	 */
	public void setName_q41(String Name_q41) {
		setAttrVal("Name_q41", Name_q41);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q42() {
		return ((String) getAttrVal("Name_q42"));
	}	
	/**
	 * 名称
	 * @param Name_q42
	 */
	public void setName_q42(String Name_q42) {
		setAttrVal("Name_q42", Name_q42);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q43() {
		return ((String) getAttrVal("Name_q43"));
	}	
	/**
	 * 名称
	 * @param Name_q43
	 */
	public void setName_q43(String Name_q43) {
		setAttrVal("Name_q43", Name_q43);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q44() {
		return ((String) getAttrVal("Name_q44"));
	}	
	/**
	 * 名称
	 * @param Name_q44
	 */
	public void setName_q44(String Name_q44) {
		setAttrVal("Name_q44", Name_q44);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q45() {
		return ((String) getAttrVal("Name_q45"));
	}	
	/**
	 * 名称
	 * @param Name_q45
	 */
	public void setName_q45(String Name_q45) {
		setAttrVal("Name_q45", Name_q45);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q46() {
		return ((String) getAttrVal("Name_q46"));
	}	
	/**
	 * 名称
	 * @param Name_q46
	 */
	public void setName_q46(String Name_q46) {
		setAttrVal("Name_q46", Name_q46);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q47() {
		return ((String) getAttrVal("Name_q47"));
	}	
	/**
	 * 名称
	 * @param Name_q47
	 */
	public void setName_q47(String Name_q47) {
		setAttrVal("Name_q47", Name_q47);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q48() {
		return ((String) getAttrVal("Name_q48"));
	}	
	/**
	 * 名称
	 * @param Name_q48
	 */
	public void setName_q48(String Name_q48) {
		setAttrVal("Name_q48", Name_q48);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q49() {
		return ((String) getAttrVal("Name_q49"));
	}	
	/**
	 * 名称
	 * @param Name_q49
	 */
	public void setName_q49(String Name_q49) {
		setAttrVal("Name_q49", Name_q49);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q50() {
		return ((String) getAttrVal("Name_q50"));
	}	
	/**
	 * 名称
	 * @param Name_q50
	 */
	public void setName_q50(String Name_q50) {
		setAttrVal("Name_q50", Name_q50);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q51() {
		return ((String) getAttrVal("Name_q51"));
	}	
	/**
	 * 名称
	 * @param Name_q51
	 */
	public void setName_q51(String Name_q51) {
		setAttrVal("Name_q51", Name_q51);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q52() {
		return ((String) getAttrVal("Name_q52"));
	}	
	/**
	 * 名称
	 * @param Name_q52
	 */
	public void setName_q52(String Name_q52) {
		setAttrVal("Name_q52", Name_q52);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q53() {
		return ((String) getAttrVal("Name_q53"));
	}	
	/**
	 * 名称
	 * @param Name_q53
	 */
	public void setName_q53(String Name_q53) {
		setAttrVal("Name_q53", Name_q53);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q54() {
		return ((String) getAttrVal("Name_q54"));
	}	
	/**
	 * 名称
	 * @param Name_q54
	 */
	public void setName_q54(String Name_q54) {
		setAttrVal("Name_q54", Name_q54);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q54_1() {
		return ((String) getAttrVal("Name_q54_1"));
	}	
	/**
	 * 名称
	 * @param Name_q54_1
	 */
	public void setName_q54_1(String Name_q54_1) {
		setAttrVal("Name_q54_1", Name_q54_1);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q54_2() {
		return ((String) getAttrVal("Name_q54_2"));
	}	
	/**
	 * 名称
	 * @param Name_q54_2
	 */
	public void setName_q54_2(String Name_q54_2) {
		setAttrVal("Name_q54_2", Name_q54_2);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q54_3() {
		return ((String) getAttrVal("Name_q54_3"));
	}	
	/**
	 * 名称
	 * @param Name_q54_3
	 */
	public void setName_q54_3(String Name_q54_3) {
		setAttrVal("Name_q54_3", Name_q54_3);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q55() {
		return ((String) getAttrVal("Name_q55"));
	}	
	/**
	 * 名称
	 * @param Name_q55
	 */
	public void setName_q55(String Name_q55) {
		setAttrVal("Name_q55", Name_q55);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q55_1() {
		return ((String) getAttrVal("Name_q55_1"));
	}	
	/**
	 * 名称
	 * @param Name_q55_1
	 */
	public void setName_q55_1(String Name_q55_1) {
		setAttrVal("Name_q55_1", Name_q55_1);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q55_2() {
		return ((String) getAttrVal("Name_q55_2"));
	}	
	/**
	 * 名称
	 * @param Name_q55_2
	 */
	public void setName_q55_2(String Name_q55_2) {
		setAttrVal("Name_q55_2", Name_q55_2);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q55_3() {
		return ((String) getAttrVal("Name_q55_3"));
	}	
	/**
	 * 名称
	 * @param Name_q55_3
	 */
	public void setName_q55_3(String Name_q55_3) {
		setAttrVal("Name_q55_3", Name_q55_3);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q56() {
		return ((String) getAttrVal("Name_q56"));
	}	
	/**
	 * 名称
	 * @param Name_q56
	 */
	public void setName_q56(String Name_q56) {
		setAttrVal("Name_q56", Name_q56);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q56_1() {
		return ((String) getAttrVal("Name_q56_1"));
	}	
	/**
	 * 名称
	 * @param Name_q56_1
	 */
	public void setName_q56_1(String Name_q56_1) {
		setAttrVal("Name_q56_1", Name_q56_1);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q57() {
		return ((String) getAttrVal("Name_q57"));
	}	
	/**
	 * 名称
	 * @param Name_q57
	 */
	public void setName_q57(String Name_q57) {
		setAttrVal("Name_q57", Name_q57);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q58() {
		return ((String) getAttrVal("Name_q58"));
	}	
	/**
	 * 名称
	 * @param Name_q58
	 */
	public void setName_q58(String Name_q58) {
		setAttrVal("Name_q58", Name_q58);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q59() {
		return ((String) getAttrVal("Name_q59"));
	}	
	/**
	 * 名称
	 * @param Name_q59
	 */
	public void setName_q59(String Name_q59) {
		setAttrVal("Name_q59", Name_q59);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q60() {
		return ((String) getAttrVal("Name_q60"));
	}	
	/**
	 * 名称
	 * @param Name_q60
	 */
	public void setName_q60(String Name_q60) {
		setAttrVal("Name_q60", Name_q60);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q61() {
		return ((String) getAttrVal("Name_q61"));
	}	
	/**
	 * 名称
	 * @param Name_q61
	 */
	public void setName_q61(String Name_q61) {
		setAttrVal("Name_q61", Name_q61);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q62() {
		return ((String) getAttrVal("Name_q62"));
	}	
	/**
	 * 名称
	 * @param Name_q62
	 */
	public void setName_q62(String Name_q62) {
		setAttrVal("Name_q62", Name_q62);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q63() {
		return ((String) getAttrVal("Name_q63"));
	}	
	/**
	 * 名称
	 * @param Name_q63
	 */
	public void setName_q63(String Name_q63) {
		setAttrVal("Name_q63", Name_q63);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q64() {
		return ((String) getAttrVal("Name_q64"));
	}	
	/**
	 * 名称
	 * @param Name_q64
	 */
	public void setName_q64(String Name_q64) {
		setAttrVal("Name_q64", Name_q64);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q65() {
		return ((String) getAttrVal("Name_q65"));
	}	
	/**
	 * 名称
	 * @param Name_q65
	 */
	public void setName_q65(String Name_q65) {
		setAttrVal("Name_q65", Name_q65);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q66() {
		return ((String) getAttrVal("Name_q66"));
	}	
	/**
	 * 名称
	 * @param Name_q66
	 */
	public void setName_q66(String Name_q66) {
		setAttrVal("Name_q66", Name_q66);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q67() {
		return ((String) getAttrVal("Name_q67"));
	}	
	/**
	 * 名称
	 * @param Name_q67
	 */
	public void setName_q67(String Name_q67) {
		setAttrVal("Name_q67", Name_q67);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_68() {
		return ((String) getAttrVal("Name_68"));
	}	
	/**
	 * 名称
	 * @param Name_68
	 */
	public void setName_68(String Name_68) {
		setAttrVal("Name_68", Name_68);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q68_1() {
		return ((String) getAttrVal("Name_q68_1"));
	}	
	/**
	 * 名称
	 * @param Name_q68_1
	 */
	public void setName_q68_1(String Name_q68_1) {
		setAttrVal("Name_q68_1", Name_q68_1);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q68_2() {
		return ((String) getAttrVal("Name_q68_2"));
	}	
	/**
	 * 名称
	 * @param Name_q68_2
	 */
	public void setName_q68_2(String Name_q68_2) {
		setAttrVal("Name_q68_2", Name_q68_2);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q69() {
		return ((String) getAttrVal("Name_q69"));
	}	
	/**
	 * 名称
	 * @param Name_q69
	 */
	public void setName_q69(String Name_q69) {
		setAttrVal("Name_q69", Name_q69);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q70() {
		return ((String) getAttrVal("Name_q70"));
	}	
	/**
	 * 名称
	 * @param Name_q70
	 */
	public void setName_q70(String Name_q70) {
		setAttrVal("Name_q70", Name_q70);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q71_1() {
		return ((String) getAttrVal("Name_q71_1"));
	}	
	/**
	 * 名称
	 * @param Name_q71_1
	 */
	public void setName_q71_1(String Name_q71_1) {
		setAttrVal("Name_q71_1", Name_q71_1);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q72() {
		return ((String) getAttrVal("Name_q72"));
	}	
	/**
	 * 名称
	 * @param Name_q72
	 */
	public void setName_q72(String Name_q72) {
		setAttrVal("Name_q72", Name_q72);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q73() {
		return ((String) getAttrVal("Name_q73"));
	}	
	/**
	 * 名称
	 * @param Name_q73
	 */
	public void setName_q73(String Name_q73) {
		setAttrVal("Name_q73", Name_q73);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q74() {
		return ((String) getAttrVal("Name_q74"));
	}	
	/**
	 * 名称
	 * @param Name_q74
	 */
	public void setName_q74(String Name_q74) {
		setAttrVal("Name_q74", Name_q74);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q75() {
		return ((String) getAttrVal("Name_q75"));
	}	
	/**
	 * 名称
	 * @param Name_q75
	 */
	public void setName_q75(String Name_q75) {
		setAttrVal("Name_q75", Name_q75);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q76() {
		return ((String) getAttrVal("Name_q76"));
	}	
	/**
	 * 名称
	 * @param Name_q76
	 */
	public void setName_q76(String Name_q76) {
		setAttrVal("Name_q76", Name_q76);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q77() {
		return ((String) getAttrVal("Name_q77"));
	}	
	/**
	 * 名称
	 * @param Name_q77
	 */
	public void setName_q77(String Name_q77) {
		setAttrVal("Name_q77", Name_q77);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q78() {
		return ((String) getAttrVal("Name_q78"));
	}	
	/**
	 * 名称
	 * @param Name_q78
	 */
	public void setName_q78(String Name_q78) {
		setAttrVal("Name_q78", Name_q78);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q79() {
		return ((String) getAttrVal("Name_q79"));
	}	
	/**
	 * 名称
	 * @param Name_q79
	 */
	public void setName_q79(String Name_q79) {
		setAttrVal("Name_q79", Name_q79);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q80() {
		return ((String) getAttrVal("Name_q80"));
	}	
	/**
	 * 名称
	 * @param Name_q80
	 */
	public void setName_q80(String Name_q80) {
		setAttrVal("Name_q80", Name_q80);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q81() {
		return ((String) getAttrVal("Name_q81"));
	}	
	/**
	 * 名称
	 * @param Name_q81
	 */
	public void setName_q81(String Name_q81) {
		setAttrVal("Name_q81", Name_q81);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_82_1() {
		return ((String) getAttrVal("Name_82_1"));
	}	
	/**
	 * 名称
	 * @param Name_82_1
	 */
	public void setName_82_1(String Name_82_1) {
		setAttrVal("Name_82_1", Name_82_1);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q82_2() {
		return ((String) getAttrVal("Name_q82_2"));
	}	
	/**
	 * 名称
	 * @param Name_q82_2
	 */
	public void setName_q82_2(String Name_q82_2) {
		setAttrVal("Name_q82_2", Name_q82_2);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q83() {
		return ((String) getAttrVal("Name_q83"));
	}	
	/**
	 * 名称
	 * @param Name_q83
	 */
	public void setName_q83(String Name_q83) {
		setAttrVal("Name_q83", Name_q83);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q84() {
		return ((String) getAttrVal("Name_q84"));
	}	
	/**
	 * 名称
	 * @param Name_q84
	 */
	public void setName_q84(String Name_q84) {
		setAttrVal("Name_q84", Name_q84);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_85() {
		return ((String) getAttrVal("Name_85"));
	}	
	/**
	 * 名称
	 * @param Name_85
	 */
	public void setName_85(String Name_85) {
		setAttrVal("Name_85", Name_85);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q86() {
		return ((String) getAttrVal("Name_q86"));
	}	
	/**
	 * 名称
	 * @param Name_q86
	 */
	public void setName_q86(String Name_q86) {
		setAttrVal("Name_q86", Name_q86);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_q87() {
		return ((String) getAttrVal("Name_q87"));
	}	
	/**
	 * 名称
	 * @param Name_q87
	 */
	public void setName_q87(String Name_q87) {
		setAttrVal("Name_q87", Name_q87);
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
		return "Id_pesurveycma";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pesurveycma";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSurveyCmaDODesc.class);
	}
	
}