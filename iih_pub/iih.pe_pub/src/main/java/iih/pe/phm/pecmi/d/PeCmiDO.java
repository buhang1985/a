package iih.pe.phm.pecmi.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pecmi.d.desc.PeCmiDODesc;
import java.math.BigDecimal;

/**
 * 体检康奈尔医学指数 DO数据 
 * 
 */
public class PeCmiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检康奈尔医学指数主键标识
	public static final String ID_PECMI= "Id_pecmi";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//体检个人预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//你读报时需要戴眼镜吗？
	public static final String A1= "A1";
	//你看远处时需要戴眼镜吗？
	public static final String A2= "A2";
	//你是否经常有一时性的眼前发黑（视力下降或看不见东西）的现象？
	public static final String A3= "A3";
	//你是否有频繁的眨眼和流泪？
	public static final String A4= "A4";
	//你的眼睛是否经常很疼(或出现看物模糊的现象)？
	public static final String A5= "A5";
	//你的眼睛是否经常发红或发炎？
	public static final String A6= "A6";
	//你是否耳背（听力差）？
	public static final String A7= "A7";
	//你是否有过中耳炎、耳朵流脓？
	public static final String A8= "A8";
	//你是否经常耳鸣？（耳中自觉有各种声响，以致影响听觉）
	public static final String A9= "A9";
	//你常常不得不为清嗓子而轻咳吗？
	public static final String B10= "B10";
	//你经常有嗓子发堵的感觉（感觉喉咙里有东西）吗？
	public static final String B11= "B11";
	//你经常连续打喷嚏吗？
	public static final String B12= "B12";
	//你是否觉得鼻子老是堵？
	public static final String B13= "B13";
	//你经常流鼻涕吗？
	public static final String B14= "B14";
	//是否有时鼻子出血很厉害？
	public static final String B15= "B15";
	//你是否经常得重感冒（或嗓子痛，扁桃体肿大）？
	public static final String B16= "B16";
	//你是否经常有严重的慢性支气管炎（在感冒时咳嗽，吐痰拖很长时间）？
	public static final String B17= "B17";
	//你在得感冒时总是必须要卧床（或经常吐痰）吗？
	public static final String B18= "B18";
	//是否经常感冒使你一冬天都很难受？
	public static final String B19= "B19";
	//你是否有过敏型哮喘？（以某些过敏因素，如花粉等为诱因的哮喘）
	public static final String B20= "B20";
	//你是否有哮喘（反复发作的，暂时性的伴有喘音的呼吸困难）
	public static final String B21= "B21";
	//你是否经常因咳嗽而感到烦恼？
	public static final String B22= "B22";
	//你是否有过咳血？
	public static final String B23= "B23";
	//你是否有较重的盗汗（睡时出汗、醒时终止）？
	public static final String B24= "B24";
	//你除结核外是否患过慢性呼吸道疾病（或有低烧（热）37-38度）？
	public static final String B25= "B25";
	//你是否得过结核病？
	public static final String B26= "B26";
	//你与得结核病的人在一起住过吗？
	public static final String B27= "B27";
	//医生说过你血压很高吗？
	public static final String C28= "C28";
	//医生说过你血压很低吗？
	public static final String C29= "C29";
	//你有胸部或心区疼痛吗？
	public static final String C30= "C30";
	//你是否经常心动过速（心跳过快）吗？
	public static final String C31= "C31";
	//你是否经常心悸（平静时有心脏跳动的感觉）或（感到脉搏有停跳）？
	public static final String C32= "C32";
	//你是否经常感到呼吸困难？
	public static final String C33= "C33";
	//你是否比别人更容易发生气短（喘不上气）？
	public static final String C34= "C34";
	//你既使在坐着的情况下有时也会感到气短吗？
	public static final String C35= "C35";
	//你是否经常有严重的下肢浮肿？
	public static final String C36= "C36";
	//你即使在热天也因手脚发凉而烦恼吗？
	public static final String C37= "C37";
	//你是否经常腿抽筋？
	public static final String C38= "C38";
	//医生说过你心脏有毛病吗？
	public static final String C39= "C39";
	//你的家属中是否有心脏病人？
	public static final String C40= "C40";
	//你是否已脱落了一半以上的牙齿？
	public static final String D41= "D41";
	//你是否因牙龈（牙床）出血而烦恼？
	public static final String D42= "D42";
	//你是否有经常的牙痛？
	public static final String D43= "D43";
	//是否你的舌苔常常很厚？
	public static final String D44= "D44";
	//你是否总是食欲不好（不想吃东西）？
	public static final String D45= "D45";
	//你是否经常吃零食？
	public static final String D46= "D46";
	//你是否吃东西时总是狼吞虎咽？
	public static final String D47= "D47";
	//你是否经常胃部不舒服（或有时恶心呕吐）？
	public static final String D48= "D48";
	//你饭后是否经常有胀满（腹部膨胀）的感觉？
	public static final String D49= "D49";
	//你饭后是否经常打饱嗝（或烧心吐酸水）？
	public static final String D50= "D50";
	//你是否经常犯胃病？
	public static final String D51= "D51";
	//你是否有消化不良？
	public static final String D52= "D52";
	//是否严重胃痛使你常常不得不弯着身子？
	public static final String D53= "D53";
	//你是否感到胃部持续不舒服？
	public static final String D54= "D54";
	//你的家属中有患胃病的人吗？
	public static final String D55= "D55";
	//医生说过你有胃或十二指肠溃疡病（或饭后、空腹时常感到胃痛）？
	public static final String D56= "D56";
	//你是否经常腹泻（拉肚子）？
	public static final String D57= "D57";
	//你腹泻时是否有严重血便或粘液（粪便发黑、有血液或沾稠物质）？
	public static final String D58= "D58";
	//你是否因曾有过肠道寄生虫而感到烦恼？
	public static final String D59= "D59";
	//你是否常有严重便秘（大便干燥）？
	public static final String D60= "D60";
	//你是否有痔疮（大便时肛门疼痛不适，大便表面带血或便后滴血）？
	public static final String D61= "D61";
	//你是否曾患过黄疸（眼、皮肤、尿发黄）？
	public static final String D62= "D62";
	//你是否得过严重肝胆疾病？
	public static final String D63= "D63";
	//你是否经常有关节肿痛？
	public static final String E64= "E64";
	//你的肌肉和关节经常感到发僵或僵硬吗？
	public static final String E65= "E65";
	//你的胳膊或腿是否经常感到严重疼痛？
	public static final String E66= "E66";
	//严重的风湿病使你丧失活动能力（或有肩、脖子肌肉发紧的现象）？
	public static final String E67= "E67";
	//你的家属中是否有人患风湿病？
	public static final String E68= "E68";
	//脚发软、疼痛使你的生活严重不便（或经常感到腿、脚发酸）？
	public static final String E69= "E69";
	//腰背痛是否达到使你不能持续工作的程度？
	public static final String E70= "E70";
	//你是否因身体有严重的功能丧失或畸形（形态异常）而感到烦恼？
	public static final String E71= "E71";
	//你的皮肤对温度、疼痛十分敏感，有压痛（或有皮下小出血点）？
	public static final String F72= "F72";
	//你皮肤上的切口通常不易愈合（长好）吗？
	public static final String F73= "F73";
	//你是否经常脸很红？
	public static final String F74= "F74";
	//即使在冷天你也大量出汗吗？
	public static final String F75= "F75";
	//是否严重的皮肤搔痒（发痒）使你感到烦恼？
	public static final String F76= "F76";
	//你是否经常出皮疹（风疙瘩或疹子）或（有时脸部浮肿）？
	public static final String F77= "F77";
	//你是否经常因生疖肿（肿包）而感到烦恼？
	public static final String F78= "F78";
	//你是否经常由于严重头痛而感到十分难受？
	public static final String G79= "G79";
	//你是否经常由于头痛、头发沉而感到生活痛苦？
	public static final String G80= "G80";
	//你的家属中头痛常见吗？
	public static final String G81= "G81";
	//你是否有一阵发热、一阵发冷的现象？
	public static final String G82= "G82";
	//你经常有一阵阵严重头晕的感觉吗？
	public static final String G83= "G83";
	//你是否经常晕倒？
	public static final String G84= "G84";
	//你是否晕倒过两次以上？
	public static final String G85= "G85";
	//你身体某部分是否有经常麻木或震颤的感觉？
	public static final String G86= "G86";
	//你身体某部分曾经瘫痪（感觉和运动能力完全或部分丧失）过吗？
	public static final String G87= "G87";
	//你是否有被撞击后失去知觉（什么都不知道了）的现象？
	public static final String G88= "G88";
	//你头、面、肩部是否有时有抽搐（突然而迅速的肌肉抽动）的感觉？
	public static final String G89= "G89";
	//你是否抽过疯（癫痫发作，也叫抽羊角疯）？
	public static final String G90= "G90";
	//你的家属中有无癫痫病人？
	public static final String G91= "G91";
	//你是否有严重的咬指甲的习惯？
	public static final String G92= "G92";
	//你是否因说话结巴或口吃而烦恼（或因舌头不灵活而导致说话困难）？
	public static final String G93= "G93";
	//你是否有梦游症（睡眠时走来走去，事后不能回忆所做的事情）？
	public static final String G94= "G94";
	//你是否尿床？
	public static final String G95= "G95";
	//在8--14岁（小学和中学）阶段你是否尿床？
	public static final String G96= "G96";
	//你的生殖器是否有过某种严重毛病？
	public static final String H97M= "H97m";
	//你是否经常有生殖器疼痛或触痛（一碰就痛）的现象？
	public static final String H98M= "H98m";
	//你是否曾接受过生殖器的治疗？
	public static final String H99M= "H99m";
	//医生说过你有脱肛（直肠脱出肛门以外）吗？
	public static final String H100M= "H100m";
	//你是否有过尿血（无痛性的）？
	public static final String H101M= "H101m";
	//你是否曾因排尿困难而烦恼？
	public static final String H102M= "H102m";
	//你是否经常痛经（月经期间及前后小肚子疼）？
	public static final String H97W= "H97w";
	//你是否在月经期经常得病或感到虚弱？
	public static final String H98W= "H98w";
	//你是否经常有月经期卧床（或经期外，有阴道流血）？
	public static final String H99W= "H99w";
	//你是否经常有持续严重的脸部潮红和出汗？
	public static final String H100W= "H100w";
	//你在月经期是否经常有焦躁情绪？
	public static final String H101W= "H101w";
	//你是否经常因白带（阴道白色粘液）异常而烦恼？
	public static final String H102W= "H102w";
	//你是否每天夜里因小便起床？
	public static final String H103= "H103";
	//你是否经常白天小便次数频繁？
	public static final String H104= "H104";
	//你是否小便时经常有烧灼感（火烧样的疼痛）？
	public static final String H105= "H105";
	//你是否有时有尿失控（不能由意识来控制排尿）？
	public static final String H106= "H106";
	//是否医生说过你的肾、膀胱有病？
	public static final String H107= "H107";
	//你是否经常感到一阵一阵很疲劳？
	public static final String I108= "I108";
	//是否工作使你感到筋疲力竭？
	public static final String I109= "I109";
	//你是否经常早晨起床后即感到疲倦和筋疲力尽？
	public static final String I110= "I110";
	//你是否稍做一点工作就感到累？
	public static final String I111= "I111";
	//你是否经常因累而吃不下饭？
	public static final String I112= "I112";
	//你是否有严重的神经衰弱？
	public static final String I113= "I113";
	//你的家属中是否有患神经衰弱的人？
	public static final String I114= "I114";
	//你是否经常患病？
	public static final String J115= "J115";
	//你是否经常由于患病而卧床？
	public static final String J116= "J116";
	//你是否总是健康不良？
	public static final String J117= "J117";
	//是否别人认为你体弱多病？
	public static final String J118= "J118";
	//你的家属中是否有患病的人？
	public static final String J119= "J119";
	//你是否曾经因严重的疼痛而不能工作？
	public static final String J120= "J120";
	//你是否总是因为担心自己的健康而受不了？
	public static final String J121= "J121";
	//你是否总是有病而且不愉快？
	public static final String J122= "J122";
	//你是否经常由于健康不好而感到不幸？
	public static final String J123= "J123";
	//你得过猩红热吗？
	public static final String K124= "K124";
	//你小时候是否得过风湿热、四肢疼痛？
	public static final String K125= "K125";
	//你曾患过疟疾吗？
	public static final String K126= "K126";
	//你由于严重贫血而接受过治疗吗？
	public static final String K127= "K127";
	//你接受过性病治疗吗？
	public static final String K128= "K128";
	//你是否有糖尿病？
	public static final String K129= "K129";
	//是否医生曾说过你有甲状腺肿（粗脖子病）？
	public static final String K130= "K130";
	//你是否接受过肿瘤或癌的治疗？
	public static final String K131= "K131";
	//你是否有什么慢性病（或曾接受过原子辐射）？
	public static final String K132= "K132";
	//你是否过瘦（体重减轻）？
	public static final String K133= "K133";
	//你是否过胖（体重增加）？
	public static final String K134= "K134";
	//是否有医生说过你有腿部静脉曲张（腿部青筋暴露）？
	public static final String K135= "K135";
	//你是否住院做过手术？
	public static final String K136= "K136";
	//你曾有过严重的外伤吗？
	public static final String K137= "K137";
	//你是否经常发生小的事故或外伤？
	public static final String K138= "K138";
	//你是否有入睡很困难或睡眠不深易醒（或经常做梦）的现象？
	public static final String L139= "L139";
	//你是否不能做到每天有规律地放松一下（休息）？
	public static final String L140= "L140";
	//你是否不容易做到每天有规律地锻炼？
	public static final String L141= "L141";
	//你是否每天吸20支以上的纸烟？
	public static final String L142= "L142";
	//你是否喝茶或喝咖啡比一般的人要多？
	public static final String L143= "L143";
	//你是否每天喝两次以上的白酒？
	public static final String L144= "L144";
	//当你考试或被提问时是否出汗很多或颤抖的很厉害？
	public static final String M145= "M145";
	//接近你的主管上级时是否紧张和发抖？
	public static final String M146= "M146";
	//当你的上级看着你工作时，你是否不知所措？
	public static final String M147= "M147";
	//当必须快速做事情时，你是否有头脑完全混乱的现象？
	public static final String M148= "M148";
	//为了避免出错，你做事必须很慢吗？
	public static final String M149= "M149";
	//你经常把指令或意图体会（理解）错吗？
	public static final String M150= "M150";
	//是否生疏的人或场所使你感到害怕？
	public static final String M151= "M151";
	//身边没有熟人时你是否因孤单而恐慌？
	public static final String M152= "M152";
	//你是否总是难以下决心（犹豫不决）？
	public static final String M153= "M153";
	//你是否总是希望有人在你身边给你出主意？
	public static final String M154= "M154";
	//别人认为你是一个很笨的人吗？
	public static final String M155= "M155";
	//除了在你自己家以外，在其它任何地方吃东西都感到烦扰吗？
	public static final String M156= "M156";
	//你在聚会中也感到孤独和悲伤吗？
	public static final String N157= "N157";
	//你是否经常感到不愉快和情绪抑郁（情绪低落）？
	public static final String N158= "N158";
	//你是否经常哭？
	public static final String N159= "N159";
	//你是否总是感到凄惨与沮丧（灰心失望）？
	public static final String N160= "N160";
	//是否你对生活感到完全绝望？
	public static final String N161= "N161";
	//你是否经常想死（一死了事）？
	public static final String N162= "N162";
	//你是否经常烦恼（愁眉不展）？
	public static final String O163= "O163";
	//你的家属中是否有愁眉不展的人？
	public static final String O164= "O164";
	//是否稍遇任何一件小事都使你紧张和疲惫？
	public static final String O165= "O165";
	//是否别人认为你是一个神经质（紧张不安，易激动）的人？
	public static final String O166= "O166";
	//你的家属中是否有神经质的人？
	public static final String O167= "O167";
	//你曾患过精神崩溃吗？
	public static final String O168= "O168";
	//你的家属中曾有过精神崩溃的人吗？
	public static final String O169= "O169";
	//你在精神病院看过病吗（因为你精神方面的问题）？
	public static final String O170= "O170";
	//你的家属中是否有人到精神病院看过病（因为精神方面的问题）？
	public static final String O171= "O171";
	//你是否经常害羞和神经过敏？
	public static final String P172= "P172";
	//你的家属中是否有害羞和神经过敏的人？
	public static final String P173= "P173";
	//是否你的感情容易受到伤害？
	public static final String P174= "P174";
	//是否你在受到批评时总是心烦意乱？
	public static final String P175= "P175";
	//别人认为你是爱挑剔的人吗？
	public static final String P176= "P176";
	//你是否经常被人误解？
	public static final String P177= "P177";
	//你即使对朋友也必须存戒心吗（不放松警惕）？
	public static final String Q178= "Q178";
	//你是否总是凭一时冲动做事情？
	public static final String Q179= "Q179";
	//你是否容易烦恼和激怒？
	public static final String Q180= "Q180";
	//你若不持续克制自己精神就垮了吗？
	public static final String Q181= "Q181";
	//是否一点不快就使你紧张和发脾气？
	public static final String Q182= "Q182";
	//在别人支使你时是否易生气？
	public static final String Q183= "Q183";
	//别人常使你不快和激怒你吗？
	public static final String Q184= "Q184";
	//当你不能马上得到你所需要的东西时就发脾气吗？
	public static final String Q185= "Q185";
	//你是否经常大发脾气？
	public static final String Q186= "Q186";
	//你是否经常发抖和战栗？
	public static final String R187= "R187";
	//你是否经常紧张焦急？
	public static final String R188= "R188";
	//你是否会被突然的声音吓一大跳（跳起或发抖得厉害）？
	public static final String R189= "R189";
	//是否不管何时，当别人大声对你时，你都被吓得发抖和发软？
	public static final String R190= "R190";
	//你对夜间突然的动静是否感到恐惧（害怕）？
	public static final String R191= "R191";
	//你是否经常因恶梦而惊醒？
	public static final String R192= "R192";
	//你是否头脑中经常反复出现某种恐怖（可怕的）想法？
	public static final String R193= "R193";
	//你是否常常毫无理由地突然感到畏惧（害怕）？
	public static final String R194= "R194";
	//你是否经常有突然出冷汗的情况？
	public static final String R195= "R195";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//健康预约单ID
	public static final String ID_PEHMAPPT= "Id_pehmappt";
	//预约日期
	public static final String DT_APPT= "Dt_appt";
	//预约号
	public static final String NO_APPT= "No_appt";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检康奈尔医学指数主键标识
	 * @return String
	 */
	public String getId_pecmi() {
		return ((String) getAttrVal("Id_pecmi"));
	}	
	/**
	 * 体检康奈尔医学指数主键标识
	 * @param Id_pecmi
	 */
	public void setId_pecmi(String Id_pecmi) {
		setAttrVal("Id_pecmi", Id_pecmi);
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
	 * 体检个人预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检个人预约单ID
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
	 * 你读报时需要戴眼镜吗？
	 * @return Integer
	 */
	public Integer getA1() {
		return ((Integer) getAttrVal("A1"));
	}	
	/**
	 * 你读报时需要戴眼镜吗？
	 * @param A1
	 */
	public void setA1(Integer A1) {
		setAttrVal("A1", A1);
	}
	/**
	 * 你看远处时需要戴眼镜吗？
	 * @return Integer
	 */
	public Integer getA2() {
		return ((Integer) getAttrVal("A2"));
	}	
	/**
	 * 你看远处时需要戴眼镜吗？
	 * @param A2
	 */
	public void setA2(Integer A2) {
		setAttrVal("A2", A2);
	}
	/**
	 * 你是否经常有一时性的眼前发黑（视力下降或看不见东西）的现象？
	 * @return Integer
	 */
	public Integer getA3() {
		return ((Integer) getAttrVal("A3"));
	}	
	/**
	 * 你是否经常有一时性的眼前发黑（视力下降或看不见东西）的现象？
	 * @param A3
	 */
	public void setA3(Integer A3) {
		setAttrVal("A3", A3);
	}
	/**
	 * 你是否有频繁的眨眼和流泪？
	 * @return Integer
	 */
	public Integer getA4() {
		return ((Integer) getAttrVal("A4"));
	}	
	/**
	 * 你是否有频繁的眨眼和流泪？
	 * @param A4
	 */
	public void setA4(Integer A4) {
		setAttrVal("A4", A4);
	}
	/**
	 * 你的眼睛是否经常很疼(或出现看物模糊的现象)？
	 * @return Integer
	 */
	public Integer getA5() {
		return ((Integer) getAttrVal("A5"));
	}	
	/**
	 * 你的眼睛是否经常很疼(或出现看物模糊的现象)？
	 * @param A5
	 */
	public void setA5(Integer A5) {
		setAttrVal("A5", A5);
	}
	/**
	 * 你的眼睛是否经常发红或发炎？
	 * @return Integer
	 */
	public Integer getA6() {
		return ((Integer) getAttrVal("A6"));
	}	
	/**
	 * 你的眼睛是否经常发红或发炎？
	 * @param A6
	 */
	public void setA6(Integer A6) {
		setAttrVal("A6", A6);
	}
	/**
	 * 你是否耳背（听力差）？
	 * @return Integer
	 */
	public Integer getA7() {
		return ((Integer) getAttrVal("A7"));
	}	
	/**
	 * 你是否耳背（听力差）？
	 * @param A7
	 */
	public void setA7(Integer A7) {
		setAttrVal("A7", A7);
	}
	/**
	 * 你是否有过中耳炎、耳朵流脓？
	 * @return Integer
	 */
	public Integer getA8() {
		return ((Integer) getAttrVal("A8"));
	}	
	/**
	 * 你是否有过中耳炎、耳朵流脓？
	 * @param A8
	 */
	public void setA8(Integer A8) {
		setAttrVal("A8", A8);
	}
	/**
	 * 你是否经常耳鸣？（耳中自觉有各种声响，以致影响听觉）
	 * @return Integer
	 */
	public Integer getA9() {
		return ((Integer) getAttrVal("A9"));
	}	
	/**
	 * 你是否经常耳鸣？（耳中自觉有各种声响，以致影响听觉）
	 * @param A9
	 */
	public void setA9(Integer A9) {
		setAttrVal("A9", A9);
	}
	/**
	 * 你常常不得不为清嗓子而轻咳吗？
	 * @return Integer
	 */
	public Integer getB10() {
		return ((Integer) getAttrVal("B10"));
	}	
	/**
	 * 你常常不得不为清嗓子而轻咳吗？
	 * @param B10
	 */
	public void setB10(Integer B10) {
		setAttrVal("B10", B10);
	}
	/**
	 * 你经常有嗓子发堵的感觉（感觉喉咙里有东西）吗？
	 * @return Integer
	 */
	public Integer getB11() {
		return ((Integer) getAttrVal("B11"));
	}	
	/**
	 * 你经常有嗓子发堵的感觉（感觉喉咙里有东西）吗？
	 * @param B11
	 */
	public void setB11(Integer B11) {
		setAttrVal("B11", B11);
	}
	/**
	 * 你经常连续打喷嚏吗？
	 * @return Integer
	 */
	public Integer getB12() {
		return ((Integer) getAttrVal("B12"));
	}	
	/**
	 * 你经常连续打喷嚏吗？
	 * @param B12
	 */
	public void setB12(Integer B12) {
		setAttrVal("B12", B12);
	}
	/**
	 * 你是否觉得鼻子老是堵？
	 * @return Integer
	 */
	public Integer getB13() {
		return ((Integer) getAttrVal("B13"));
	}	
	/**
	 * 你是否觉得鼻子老是堵？
	 * @param B13
	 */
	public void setB13(Integer B13) {
		setAttrVal("B13", B13);
	}
	/**
	 * 你经常流鼻涕吗？
	 * @return Integer
	 */
	public Integer getB14() {
		return ((Integer) getAttrVal("B14"));
	}	
	/**
	 * 你经常流鼻涕吗？
	 * @param B14
	 */
	public void setB14(Integer B14) {
		setAttrVal("B14", B14);
	}
	/**
	 * 是否有时鼻子出血很厉害？
	 * @return Integer
	 */
	public Integer getB15() {
		return ((Integer) getAttrVal("B15"));
	}	
	/**
	 * 是否有时鼻子出血很厉害？
	 * @param B15
	 */
	public void setB15(Integer B15) {
		setAttrVal("B15", B15);
	}
	/**
	 * 你是否经常得重感冒（或嗓子痛，扁桃体肿大）？
	 * @return Integer
	 */
	public Integer getB16() {
		return ((Integer) getAttrVal("B16"));
	}	
	/**
	 * 你是否经常得重感冒（或嗓子痛，扁桃体肿大）？
	 * @param B16
	 */
	public void setB16(Integer B16) {
		setAttrVal("B16", B16);
	}
	/**
	 * 你是否经常有严重的慢性支气管炎（在感冒时咳嗽，吐痰拖很长时间）？
	 * @return Integer
	 */
	public Integer getB17() {
		return ((Integer) getAttrVal("B17"));
	}	
	/**
	 * 你是否经常有严重的慢性支气管炎（在感冒时咳嗽，吐痰拖很长时间）？
	 * @param B17
	 */
	public void setB17(Integer B17) {
		setAttrVal("B17", B17);
	}
	/**
	 * 你在得感冒时总是必须要卧床（或经常吐痰）吗？
	 * @return Integer
	 */
	public Integer getB18() {
		return ((Integer) getAttrVal("B18"));
	}	
	/**
	 * 你在得感冒时总是必须要卧床（或经常吐痰）吗？
	 * @param B18
	 */
	public void setB18(Integer B18) {
		setAttrVal("B18", B18);
	}
	/**
	 * 是否经常感冒使你一冬天都很难受？
	 * @return Integer
	 */
	public Integer getB19() {
		return ((Integer) getAttrVal("B19"));
	}	
	/**
	 * 是否经常感冒使你一冬天都很难受？
	 * @param B19
	 */
	public void setB19(Integer B19) {
		setAttrVal("B19", B19);
	}
	/**
	 * 你是否有过敏型哮喘？（以某些过敏因素，如花粉等为诱因的哮喘）
	 * @return Integer
	 */
	public Integer getB20() {
		return ((Integer) getAttrVal("B20"));
	}	
	/**
	 * 你是否有过敏型哮喘？（以某些过敏因素，如花粉等为诱因的哮喘）
	 * @param B20
	 */
	public void setB20(Integer B20) {
		setAttrVal("B20", B20);
	}
	/**
	 * 你是否有哮喘（反复发作的，暂时性的伴有喘音的呼吸困难）
	 * @return Integer
	 */
	public Integer getB21() {
		return ((Integer) getAttrVal("B21"));
	}	
	/**
	 * 你是否有哮喘（反复发作的，暂时性的伴有喘音的呼吸困难）
	 * @param B21
	 */
	public void setB21(Integer B21) {
		setAttrVal("B21", B21);
	}
	/**
	 * 你是否经常因咳嗽而感到烦恼？
	 * @return Integer
	 */
	public Integer getB22() {
		return ((Integer) getAttrVal("B22"));
	}	
	/**
	 * 你是否经常因咳嗽而感到烦恼？
	 * @param B22
	 */
	public void setB22(Integer B22) {
		setAttrVal("B22", B22);
	}
	/**
	 * 你是否有过咳血？
	 * @return Integer
	 */
	public Integer getB23() {
		return ((Integer) getAttrVal("B23"));
	}	
	/**
	 * 你是否有过咳血？
	 * @param B23
	 */
	public void setB23(Integer B23) {
		setAttrVal("B23", B23);
	}
	/**
	 * 你是否有较重的盗汗（睡时出汗、醒时终止）？
	 * @return Integer
	 */
	public Integer getB24() {
		return ((Integer) getAttrVal("B24"));
	}	
	/**
	 * 你是否有较重的盗汗（睡时出汗、醒时终止）？
	 * @param B24
	 */
	public void setB24(Integer B24) {
		setAttrVal("B24", B24);
	}
	/**
	 * 你除结核外是否患过慢性呼吸道疾病（或有低烧（热）37-38度）？
	 * @return Integer
	 */
	public Integer getB25() {
		return ((Integer) getAttrVal("B25"));
	}	
	/**
	 * 你除结核外是否患过慢性呼吸道疾病（或有低烧（热）37-38度）？
	 * @param B25
	 */
	public void setB25(Integer B25) {
		setAttrVal("B25", B25);
	}
	/**
	 * 你是否得过结核病？
	 * @return Integer
	 */
	public Integer getB26() {
		return ((Integer) getAttrVal("B26"));
	}	
	/**
	 * 你是否得过结核病？
	 * @param B26
	 */
	public void setB26(Integer B26) {
		setAttrVal("B26", B26);
	}
	/**
	 * 你与得结核病的人在一起住过吗？
	 * @return Integer
	 */
	public Integer getB27() {
		return ((Integer) getAttrVal("B27"));
	}	
	/**
	 * 你与得结核病的人在一起住过吗？
	 * @param B27
	 */
	public void setB27(Integer B27) {
		setAttrVal("B27", B27);
	}
	/**
	 * 医生说过你血压很高吗？
	 * @return Integer
	 */
	public Integer getC28() {
		return ((Integer) getAttrVal("C28"));
	}	
	/**
	 * 医生说过你血压很高吗？
	 * @param C28
	 */
	public void setC28(Integer C28) {
		setAttrVal("C28", C28);
	}
	/**
	 * 医生说过你血压很低吗？
	 * @return Integer
	 */
	public Integer getC29() {
		return ((Integer) getAttrVal("C29"));
	}	
	/**
	 * 医生说过你血压很低吗？
	 * @param C29
	 */
	public void setC29(Integer C29) {
		setAttrVal("C29", C29);
	}
	/**
	 * 你有胸部或心区疼痛吗？
	 * @return Integer
	 */
	public Integer getC30() {
		return ((Integer) getAttrVal("C30"));
	}	
	/**
	 * 你有胸部或心区疼痛吗？
	 * @param C30
	 */
	public void setC30(Integer C30) {
		setAttrVal("C30", C30);
	}
	/**
	 * 你是否经常心动过速（心跳过快）吗？
	 * @return Integer
	 */
	public Integer getC31() {
		return ((Integer) getAttrVal("C31"));
	}	
	/**
	 * 你是否经常心动过速（心跳过快）吗？
	 * @param C31
	 */
	public void setC31(Integer C31) {
		setAttrVal("C31", C31);
	}
	/**
	 * 你是否经常心悸（平静时有心脏跳动的感觉）或（感到脉搏有停跳）？
	 * @return Integer
	 */
	public Integer getC32() {
		return ((Integer) getAttrVal("C32"));
	}	
	/**
	 * 你是否经常心悸（平静时有心脏跳动的感觉）或（感到脉搏有停跳）？
	 * @param C32
	 */
	public void setC32(Integer C32) {
		setAttrVal("C32", C32);
	}
	/**
	 * 你是否经常感到呼吸困难？
	 * @return Integer
	 */
	public Integer getC33() {
		return ((Integer) getAttrVal("C33"));
	}	
	/**
	 * 你是否经常感到呼吸困难？
	 * @param C33
	 */
	public void setC33(Integer C33) {
		setAttrVal("C33", C33);
	}
	/**
	 * 你是否比别人更容易发生气短（喘不上气）？
	 * @return Integer
	 */
	public Integer getC34() {
		return ((Integer) getAttrVal("C34"));
	}	
	/**
	 * 你是否比别人更容易发生气短（喘不上气）？
	 * @param C34
	 */
	public void setC34(Integer C34) {
		setAttrVal("C34", C34);
	}
	/**
	 * 你既使在坐着的情况下有时也会感到气短吗？
	 * @return Integer
	 */
	public Integer getC35() {
		return ((Integer) getAttrVal("C35"));
	}	
	/**
	 * 你既使在坐着的情况下有时也会感到气短吗？
	 * @param C35
	 */
	public void setC35(Integer C35) {
		setAttrVal("C35", C35);
	}
	/**
	 * 你是否经常有严重的下肢浮肿？
	 * @return Integer
	 */
	public Integer getC36() {
		return ((Integer) getAttrVal("C36"));
	}	
	/**
	 * 你是否经常有严重的下肢浮肿？
	 * @param C36
	 */
	public void setC36(Integer C36) {
		setAttrVal("C36", C36);
	}
	/**
	 * 你即使在热天也因手脚发凉而烦恼吗？
	 * @return Integer
	 */
	public Integer getC37() {
		return ((Integer) getAttrVal("C37"));
	}	
	/**
	 * 你即使在热天也因手脚发凉而烦恼吗？
	 * @param C37
	 */
	public void setC37(Integer C37) {
		setAttrVal("C37", C37);
	}
	/**
	 * 你是否经常腿抽筋？
	 * @return Integer
	 */
	public Integer getC38() {
		return ((Integer) getAttrVal("C38"));
	}	
	/**
	 * 你是否经常腿抽筋？
	 * @param C38
	 */
	public void setC38(Integer C38) {
		setAttrVal("C38", C38);
	}
	/**
	 * 医生说过你心脏有毛病吗？
	 * @return Integer
	 */
	public Integer getC39() {
		return ((Integer) getAttrVal("C39"));
	}	
	/**
	 * 医生说过你心脏有毛病吗？
	 * @param C39
	 */
	public void setC39(Integer C39) {
		setAttrVal("C39", C39);
	}
	/**
	 * 你的家属中是否有心脏病人？
	 * @return Integer
	 */
	public Integer getC40() {
		return ((Integer) getAttrVal("C40"));
	}	
	/**
	 * 你的家属中是否有心脏病人？
	 * @param C40
	 */
	public void setC40(Integer C40) {
		setAttrVal("C40", C40);
	}
	/**
	 * 你是否已脱落了一半以上的牙齿？
	 * @return Integer
	 */
	public Integer getD41() {
		return ((Integer) getAttrVal("D41"));
	}	
	/**
	 * 你是否已脱落了一半以上的牙齿？
	 * @param D41
	 */
	public void setD41(Integer D41) {
		setAttrVal("D41", D41);
	}
	/**
	 * 你是否因牙龈（牙床）出血而烦恼？
	 * @return Integer
	 */
	public Integer getD42() {
		return ((Integer) getAttrVal("D42"));
	}	
	/**
	 * 你是否因牙龈（牙床）出血而烦恼？
	 * @param D42
	 */
	public void setD42(Integer D42) {
		setAttrVal("D42", D42);
	}
	/**
	 * 你是否有经常的牙痛？
	 * @return Integer
	 */
	public Integer getD43() {
		return ((Integer) getAttrVal("D43"));
	}	
	/**
	 * 你是否有经常的牙痛？
	 * @param D43
	 */
	public void setD43(Integer D43) {
		setAttrVal("D43", D43);
	}
	/**
	 * 是否你的舌苔常常很厚？
	 * @return Integer
	 */
	public Integer getD44() {
		return ((Integer) getAttrVal("D44"));
	}	
	/**
	 * 是否你的舌苔常常很厚？
	 * @param D44
	 */
	public void setD44(Integer D44) {
		setAttrVal("D44", D44);
	}
	/**
	 * 你是否总是食欲不好（不想吃东西）？
	 * @return Integer
	 */
	public Integer getD45() {
		return ((Integer) getAttrVal("D45"));
	}	
	/**
	 * 你是否总是食欲不好（不想吃东西）？
	 * @param D45
	 */
	public void setD45(Integer D45) {
		setAttrVal("D45", D45);
	}
	/**
	 * 你是否经常吃零食？
	 * @return Integer
	 */
	public Integer getD46() {
		return ((Integer) getAttrVal("D46"));
	}	
	/**
	 * 你是否经常吃零食？
	 * @param D46
	 */
	public void setD46(Integer D46) {
		setAttrVal("D46", D46);
	}
	/**
	 * 你是否吃东西时总是狼吞虎咽？
	 * @return Integer
	 */
	public Integer getD47() {
		return ((Integer) getAttrVal("D47"));
	}	
	/**
	 * 你是否吃东西时总是狼吞虎咽？
	 * @param D47
	 */
	public void setD47(Integer D47) {
		setAttrVal("D47", D47);
	}
	/**
	 * 你是否经常胃部不舒服（或有时恶心呕吐）？
	 * @return Integer
	 */
	public Integer getD48() {
		return ((Integer) getAttrVal("D48"));
	}	
	/**
	 * 你是否经常胃部不舒服（或有时恶心呕吐）？
	 * @param D48
	 */
	public void setD48(Integer D48) {
		setAttrVal("D48", D48);
	}
	/**
	 * 你饭后是否经常有胀满（腹部膨胀）的感觉？
	 * @return Integer
	 */
	public Integer getD49() {
		return ((Integer) getAttrVal("D49"));
	}	
	/**
	 * 你饭后是否经常有胀满（腹部膨胀）的感觉？
	 * @param D49
	 */
	public void setD49(Integer D49) {
		setAttrVal("D49", D49);
	}
	/**
	 * 你饭后是否经常打饱嗝（或烧心吐酸水）？
	 * @return Integer
	 */
	public Integer getD50() {
		return ((Integer) getAttrVal("D50"));
	}	
	/**
	 * 你饭后是否经常打饱嗝（或烧心吐酸水）？
	 * @param D50
	 */
	public void setD50(Integer D50) {
		setAttrVal("D50", D50);
	}
	/**
	 * 你是否经常犯胃病？
	 * @return Integer
	 */
	public Integer getD51() {
		return ((Integer) getAttrVal("D51"));
	}	
	/**
	 * 你是否经常犯胃病？
	 * @param D51
	 */
	public void setD51(Integer D51) {
		setAttrVal("D51", D51);
	}
	/**
	 * 你是否有消化不良？
	 * @return Integer
	 */
	public Integer getD52() {
		return ((Integer) getAttrVal("D52"));
	}	
	/**
	 * 你是否有消化不良？
	 * @param D52
	 */
	public void setD52(Integer D52) {
		setAttrVal("D52", D52);
	}
	/**
	 * 是否严重胃痛使你常常不得不弯着身子？
	 * @return Integer
	 */
	public Integer getD53() {
		return ((Integer) getAttrVal("D53"));
	}	
	/**
	 * 是否严重胃痛使你常常不得不弯着身子？
	 * @param D53
	 */
	public void setD53(Integer D53) {
		setAttrVal("D53", D53);
	}
	/**
	 * 你是否感到胃部持续不舒服？
	 * @return Integer
	 */
	public Integer getD54() {
		return ((Integer) getAttrVal("D54"));
	}	
	/**
	 * 你是否感到胃部持续不舒服？
	 * @param D54
	 */
	public void setD54(Integer D54) {
		setAttrVal("D54", D54);
	}
	/**
	 * 你的家属中有患胃病的人吗？
	 * @return Integer
	 */
	public Integer getD55() {
		return ((Integer) getAttrVal("D55"));
	}	
	/**
	 * 你的家属中有患胃病的人吗？
	 * @param D55
	 */
	public void setD55(Integer D55) {
		setAttrVal("D55", D55);
	}
	/**
	 * 医生说过你有胃或十二指肠溃疡病（或饭后、空腹时常感到胃痛）？
	 * @return Integer
	 */
	public Integer getD56() {
		return ((Integer) getAttrVal("D56"));
	}	
	/**
	 * 医生说过你有胃或十二指肠溃疡病（或饭后、空腹时常感到胃痛）？
	 * @param D56
	 */
	public void setD56(Integer D56) {
		setAttrVal("D56", D56);
	}
	/**
	 * 你是否经常腹泻（拉肚子）？
	 * @return Integer
	 */
	public Integer getD57() {
		return ((Integer) getAttrVal("D57"));
	}	
	/**
	 * 你是否经常腹泻（拉肚子）？
	 * @param D57
	 */
	public void setD57(Integer D57) {
		setAttrVal("D57", D57);
	}
	/**
	 * 你腹泻时是否有严重血便或粘液（粪便发黑、有血液或沾稠物质）？
	 * @return Integer
	 */
	public Integer getD58() {
		return ((Integer) getAttrVal("D58"));
	}	
	/**
	 * 你腹泻时是否有严重血便或粘液（粪便发黑、有血液或沾稠物质）？
	 * @param D58
	 */
	public void setD58(Integer D58) {
		setAttrVal("D58", D58);
	}
	/**
	 * 你是否因曾有过肠道寄生虫而感到烦恼？
	 * @return Integer
	 */
	public Integer getD59() {
		return ((Integer) getAttrVal("D59"));
	}	
	/**
	 * 你是否因曾有过肠道寄生虫而感到烦恼？
	 * @param D59
	 */
	public void setD59(Integer D59) {
		setAttrVal("D59", D59);
	}
	/**
	 * 你是否常有严重便秘（大便干燥）？
	 * @return Integer
	 */
	public Integer getD60() {
		return ((Integer) getAttrVal("D60"));
	}	
	/**
	 * 你是否常有严重便秘（大便干燥）？
	 * @param D60
	 */
	public void setD60(Integer D60) {
		setAttrVal("D60", D60);
	}
	/**
	 * 你是否有痔疮（大便时肛门疼痛不适，大便表面带血或便后滴血）？
	 * @return Integer
	 */
	public Integer getD61() {
		return ((Integer) getAttrVal("D61"));
	}	
	/**
	 * 你是否有痔疮（大便时肛门疼痛不适，大便表面带血或便后滴血）？
	 * @param D61
	 */
	public void setD61(Integer D61) {
		setAttrVal("D61", D61);
	}
	/**
	 * 你是否曾患过黄疸（眼、皮肤、尿发黄）？
	 * @return Integer
	 */
	public Integer getD62() {
		return ((Integer) getAttrVal("D62"));
	}	
	/**
	 * 你是否曾患过黄疸（眼、皮肤、尿发黄）？
	 * @param D62
	 */
	public void setD62(Integer D62) {
		setAttrVal("D62", D62);
	}
	/**
	 * 你是否得过严重肝胆疾病？
	 * @return Integer
	 */
	public Integer getD63() {
		return ((Integer) getAttrVal("D63"));
	}	
	/**
	 * 你是否得过严重肝胆疾病？
	 * @param D63
	 */
	public void setD63(Integer D63) {
		setAttrVal("D63", D63);
	}
	/**
	 * 你是否经常有关节肿痛？
	 * @return Integer
	 */
	public Integer getE64() {
		return ((Integer) getAttrVal("E64"));
	}	
	/**
	 * 你是否经常有关节肿痛？
	 * @param E64
	 */
	public void setE64(Integer E64) {
		setAttrVal("E64", E64);
	}
	/**
	 * 你的肌肉和关节经常感到发僵或僵硬吗？
	 * @return Integer
	 */
	public Integer getE65() {
		return ((Integer) getAttrVal("E65"));
	}	
	/**
	 * 你的肌肉和关节经常感到发僵或僵硬吗？
	 * @param E65
	 */
	public void setE65(Integer E65) {
		setAttrVal("E65", E65);
	}
	/**
	 * 你的胳膊或腿是否经常感到严重疼痛？
	 * @return Integer
	 */
	public Integer getE66() {
		return ((Integer) getAttrVal("E66"));
	}	
	/**
	 * 你的胳膊或腿是否经常感到严重疼痛？
	 * @param E66
	 */
	public void setE66(Integer E66) {
		setAttrVal("E66", E66);
	}
	/**
	 * 严重的风湿病使你丧失活动能力（或有肩、脖子肌肉发紧的现象）？
	 * @return Integer
	 */
	public Integer getE67() {
		return ((Integer) getAttrVal("E67"));
	}	
	/**
	 * 严重的风湿病使你丧失活动能力（或有肩、脖子肌肉发紧的现象）？
	 * @param E67
	 */
	public void setE67(Integer E67) {
		setAttrVal("E67", E67);
	}
	/**
	 * 你的家属中是否有人患风湿病？
	 * @return Integer
	 */
	public Integer getE68() {
		return ((Integer) getAttrVal("E68"));
	}	
	/**
	 * 你的家属中是否有人患风湿病？
	 * @param E68
	 */
	public void setE68(Integer E68) {
		setAttrVal("E68", E68);
	}
	/**
	 * 脚发软、疼痛使你的生活严重不便（或经常感到腿、脚发酸）？
	 * @return Integer
	 */
	public Integer getE69() {
		return ((Integer) getAttrVal("E69"));
	}	
	/**
	 * 脚发软、疼痛使你的生活严重不便（或经常感到腿、脚发酸）？
	 * @param E69
	 */
	public void setE69(Integer E69) {
		setAttrVal("E69", E69);
	}
	/**
	 * 腰背痛是否达到使你不能持续工作的程度？
	 * @return Integer
	 */
	public Integer getE70() {
		return ((Integer) getAttrVal("E70"));
	}	
	/**
	 * 腰背痛是否达到使你不能持续工作的程度？
	 * @param E70
	 */
	public void setE70(Integer E70) {
		setAttrVal("E70", E70);
	}
	/**
	 * 你是否因身体有严重的功能丧失或畸形（形态异常）而感到烦恼？
	 * @return Integer
	 */
	public Integer getE71() {
		return ((Integer) getAttrVal("E71"));
	}	
	/**
	 * 你是否因身体有严重的功能丧失或畸形（形态异常）而感到烦恼？
	 * @param E71
	 */
	public void setE71(Integer E71) {
		setAttrVal("E71", E71);
	}
	/**
	 * 你的皮肤对温度、疼痛十分敏感，有压痛（或有皮下小出血点）？
	 * @return Integer
	 */
	public Integer getF72() {
		return ((Integer) getAttrVal("F72"));
	}	
	/**
	 * 你的皮肤对温度、疼痛十分敏感，有压痛（或有皮下小出血点）？
	 * @param F72
	 */
	public void setF72(Integer F72) {
		setAttrVal("F72", F72);
	}
	/**
	 * 你皮肤上的切口通常不易愈合（长好）吗？
	 * @return Integer
	 */
	public Integer getF73() {
		return ((Integer) getAttrVal("F73"));
	}	
	/**
	 * 你皮肤上的切口通常不易愈合（长好）吗？
	 * @param F73
	 */
	public void setF73(Integer F73) {
		setAttrVal("F73", F73);
	}
	/**
	 * 你是否经常脸很红？
	 * @return Integer
	 */
	public Integer getF74() {
		return ((Integer) getAttrVal("F74"));
	}	
	/**
	 * 你是否经常脸很红？
	 * @param F74
	 */
	public void setF74(Integer F74) {
		setAttrVal("F74", F74);
	}
	/**
	 * 即使在冷天你也大量出汗吗？
	 * @return Integer
	 */
	public Integer getF75() {
		return ((Integer) getAttrVal("F75"));
	}	
	/**
	 * 即使在冷天你也大量出汗吗？
	 * @param F75
	 */
	public void setF75(Integer F75) {
		setAttrVal("F75", F75);
	}
	/**
	 * 是否严重的皮肤搔痒（发痒）使你感到烦恼？
	 * @return Integer
	 */
	public Integer getF76() {
		return ((Integer) getAttrVal("F76"));
	}	
	/**
	 * 是否严重的皮肤搔痒（发痒）使你感到烦恼？
	 * @param F76
	 */
	public void setF76(Integer F76) {
		setAttrVal("F76", F76);
	}
	/**
	 * 你是否经常出皮疹（风疙瘩或疹子）或（有时脸部浮肿）？
	 * @return Integer
	 */
	public Integer getF77() {
		return ((Integer) getAttrVal("F77"));
	}	
	/**
	 * 你是否经常出皮疹（风疙瘩或疹子）或（有时脸部浮肿）？
	 * @param F77
	 */
	public void setF77(Integer F77) {
		setAttrVal("F77", F77);
	}
	/**
	 * 你是否经常因生疖肿（肿包）而感到烦恼？
	 * @return Integer
	 */
	public Integer getF78() {
		return ((Integer) getAttrVal("F78"));
	}	
	/**
	 * 你是否经常因生疖肿（肿包）而感到烦恼？
	 * @param F78
	 */
	public void setF78(Integer F78) {
		setAttrVal("F78", F78);
	}
	/**
	 * 你是否经常由于严重头痛而感到十分难受？
	 * @return Integer
	 */
	public Integer getG79() {
		return ((Integer) getAttrVal("G79"));
	}	
	/**
	 * 你是否经常由于严重头痛而感到十分难受？
	 * @param G79
	 */
	public void setG79(Integer G79) {
		setAttrVal("G79", G79);
	}
	/**
	 * 你是否经常由于头痛、头发沉而感到生活痛苦？
	 * @return Integer
	 */
	public Integer getG80() {
		return ((Integer) getAttrVal("G80"));
	}	
	/**
	 * 你是否经常由于头痛、头发沉而感到生活痛苦？
	 * @param G80
	 */
	public void setG80(Integer G80) {
		setAttrVal("G80", G80);
	}
	/**
	 * 你的家属中头痛常见吗？
	 * @return Integer
	 */
	public Integer getG81() {
		return ((Integer) getAttrVal("G81"));
	}	
	/**
	 * 你的家属中头痛常见吗？
	 * @param G81
	 */
	public void setG81(Integer G81) {
		setAttrVal("G81", G81);
	}
	/**
	 * 你是否有一阵发热、一阵发冷的现象？
	 * @return Integer
	 */
	public Integer getG82() {
		return ((Integer) getAttrVal("G82"));
	}	
	/**
	 * 你是否有一阵发热、一阵发冷的现象？
	 * @param G82
	 */
	public void setG82(Integer G82) {
		setAttrVal("G82", G82);
	}
	/**
	 * 你经常有一阵阵严重头晕的感觉吗？
	 * @return Integer
	 */
	public Integer getG83() {
		return ((Integer) getAttrVal("G83"));
	}	
	/**
	 * 你经常有一阵阵严重头晕的感觉吗？
	 * @param G83
	 */
	public void setG83(Integer G83) {
		setAttrVal("G83", G83);
	}
	/**
	 * 你是否经常晕倒？
	 * @return Integer
	 */
	public Integer getG84() {
		return ((Integer) getAttrVal("G84"));
	}	
	/**
	 * 你是否经常晕倒？
	 * @param G84
	 */
	public void setG84(Integer G84) {
		setAttrVal("G84", G84);
	}
	/**
	 * 你是否晕倒过两次以上？
	 * @return Integer
	 */
	public Integer getG85() {
		return ((Integer) getAttrVal("G85"));
	}	
	/**
	 * 你是否晕倒过两次以上？
	 * @param G85
	 */
	public void setG85(Integer G85) {
		setAttrVal("G85", G85);
	}
	/**
	 * 你身体某部分是否有经常麻木或震颤的感觉？
	 * @return Integer
	 */
	public Integer getG86() {
		return ((Integer) getAttrVal("G86"));
	}	
	/**
	 * 你身体某部分是否有经常麻木或震颤的感觉？
	 * @param G86
	 */
	public void setG86(Integer G86) {
		setAttrVal("G86", G86);
	}
	/**
	 * 你身体某部分曾经瘫痪（感觉和运动能力完全或部分丧失）过吗？
	 * @return Integer
	 */
	public Integer getG87() {
		return ((Integer) getAttrVal("G87"));
	}	
	/**
	 * 你身体某部分曾经瘫痪（感觉和运动能力完全或部分丧失）过吗？
	 * @param G87
	 */
	public void setG87(Integer G87) {
		setAttrVal("G87", G87);
	}
	/**
	 * 你是否有被撞击后失去知觉（什么都不知道了）的现象？
	 * @return Integer
	 */
	public Integer getG88() {
		return ((Integer) getAttrVal("G88"));
	}	
	/**
	 * 你是否有被撞击后失去知觉（什么都不知道了）的现象？
	 * @param G88
	 */
	public void setG88(Integer G88) {
		setAttrVal("G88", G88);
	}
	/**
	 * 你头、面、肩部是否有时有抽搐（突然而迅速的肌肉抽动）的感觉？
	 * @return Integer
	 */
	public Integer getG89() {
		return ((Integer) getAttrVal("G89"));
	}	
	/**
	 * 你头、面、肩部是否有时有抽搐（突然而迅速的肌肉抽动）的感觉？
	 * @param G89
	 */
	public void setG89(Integer G89) {
		setAttrVal("G89", G89);
	}
	/**
	 * 你是否抽过疯（癫痫发作，也叫抽羊角疯）？
	 * @return Integer
	 */
	public Integer getG90() {
		return ((Integer) getAttrVal("G90"));
	}	
	/**
	 * 你是否抽过疯（癫痫发作，也叫抽羊角疯）？
	 * @param G90
	 */
	public void setG90(Integer G90) {
		setAttrVal("G90", G90);
	}
	/**
	 * 你的家属中有无癫痫病人？
	 * @return Integer
	 */
	public Integer getG91() {
		return ((Integer) getAttrVal("G91"));
	}	
	/**
	 * 你的家属中有无癫痫病人？
	 * @param G91
	 */
	public void setG91(Integer G91) {
		setAttrVal("G91", G91);
	}
	/**
	 * 你是否有严重的咬指甲的习惯？
	 * @return Integer
	 */
	public Integer getG92() {
		return ((Integer) getAttrVal("G92"));
	}	
	/**
	 * 你是否有严重的咬指甲的习惯？
	 * @param G92
	 */
	public void setG92(Integer G92) {
		setAttrVal("G92", G92);
	}
	/**
	 * 你是否因说话结巴或口吃而烦恼（或因舌头不灵活而导致说话困难）？
	 * @return Integer
	 */
	public Integer getG93() {
		return ((Integer) getAttrVal("G93"));
	}	
	/**
	 * 你是否因说话结巴或口吃而烦恼（或因舌头不灵活而导致说话困难）？
	 * @param G93
	 */
	public void setG93(Integer G93) {
		setAttrVal("G93", G93);
	}
	/**
	 * 你是否有梦游症（睡眠时走来走去，事后不能回忆所做的事情）？
	 * @return Integer
	 */
	public Integer getG94() {
		return ((Integer) getAttrVal("G94"));
	}	
	/**
	 * 你是否有梦游症（睡眠时走来走去，事后不能回忆所做的事情）？
	 * @param G94
	 */
	public void setG94(Integer G94) {
		setAttrVal("G94", G94);
	}
	/**
	 * 你是否尿床？
	 * @return Integer
	 */
	public Integer getG95() {
		return ((Integer) getAttrVal("G95"));
	}	
	/**
	 * 你是否尿床？
	 * @param G95
	 */
	public void setG95(Integer G95) {
		setAttrVal("G95", G95);
	}
	/**
	 * 在8--14岁（小学和中学）阶段你是否尿床？
	 * @return Integer
	 */
	public Integer getG96() {
		return ((Integer) getAttrVal("G96"));
	}	
	/**
	 * 在8--14岁（小学和中学）阶段你是否尿床？
	 * @param G96
	 */
	public void setG96(Integer G96) {
		setAttrVal("G96", G96);
	}
	/**
	 * 你的生殖器是否有过某种严重毛病？
	 * @return Integer
	 */
	public Integer getH97m() {
		return ((Integer) getAttrVal("H97m"));
	}	
	/**
	 * 你的生殖器是否有过某种严重毛病？
	 * @param H97m
	 */
	public void setH97m(Integer H97m) {
		setAttrVal("H97m", H97m);
	}
	/**
	 * 你是否经常有生殖器疼痛或触痛（一碰就痛）的现象？
	 * @return Integer
	 */
	public Integer getH98m() {
		return ((Integer) getAttrVal("H98m"));
	}	
	/**
	 * 你是否经常有生殖器疼痛或触痛（一碰就痛）的现象？
	 * @param H98m
	 */
	public void setH98m(Integer H98m) {
		setAttrVal("H98m", H98m);
	}
	/**
	 * 你是否曾接受过生殖器的治疗？
	 * @return Integer
	 */
	public Integer getH99m() {
		return ((Integer) getAttrVal("H99m"));
	}	
	/**
	 * 你是否曾接受过生殖器的治疗？
	 * @param H99m
	 */
	public void setH99m(Integer H99m) {
		setAttrVal("H99m", H99m);
	}
	/**
	 * 医生说过你有脱肛（直肠脱出肛门以外）吗？
	 * @return Integer
	 */
	public Integer getH100m() {
		return ((Integer) getAttrVal("H100m"));
	}	
	/**
	 * 医生说过你有脱肛（直肠脱出肛门以外）吗？
	 * @param H100m
	 */
	public void setH100m(Integer H100m) {
		setAttrVal("H100m", H100m);
	}
	/**
	 * 你是否有过尿血（无痛性的）？
	 * @return Integer
	 */
	public Integer getH101m() {
		return ((Integer) getAttrVal("H101m"));
	}	
	/**
	 * 你是否有过尿血（无痛性的）？
	 * @param H101m
	 */
	public void setH101m(Integer H101m) {
		setAttrVal("H101m", H101m);
	}
	/**
	 * 你是否曾因排尿困难而烦恼？
	 * @return Integer
	 */
	public Integer getH102m() {
		return ((Integer) getAttrVal("H102m"));
	}	
	/**
	 * 你是否曾因排尿困难而烦恼？
	 * @param H102m
	 */
	public void setH102m(Integer H102m) {
		setAttrVal("H102m", H102m);
	}
	/**
	 * 你是否经常痛经（月经期间及前后小肚子疼）？
	 * @return Integer
	 */
	public Integer getH97w() {
		return ((Integer) getAttrVal("H97w"));
	}	
	/**
	 * 你是否经常痛经（月经期间及前后小肚子疼）？
	 * @param H97w
	 */
	public void setH97w(Integer H97w) {
		setAttrVal("H97w", H97w);
	}
	/**
	 * 你是否在月经期经常得病或感到虚弱？
	 * @return Integer
	 */
	public Integer getH98w() {
		return ((Integer) getAttrVal("H98w"));
	}	
	/**
	 * 你是否在月经期经常得病或感到虚弱？
	 * @param H98w
	 */
	public void setH98w(Integer H98w) {
		setAttrVal("H98w", H98w);
	}
	/**
	 * 你是否经常有月经期卧床（或经期外，有阴道流血）？
	 * @return Integer
	 */
	public Integer getH99w() {
		return ((Integer) getAttrVal("H99w"));
	}	
	/**
	 * 你是否经常有月经期卧床（或经期外，有阴道流血）？
	 * @param H99w
	 */
	public void setH99w(Integer H99w) {
		setAttrVal("H99w", H99w);
	}
	/**
	 * 你是否经常有持续严重的脸部潮红和出汗？
	 * @return Integer
	 */
	public Integer getH100w() {
		return ((Integer) getAttrVal("H100w"));
	}	
	/**
	 * 你是否经常有持续严重的脸部潮红和出汗？
	 * @param H100w
	 */
	public void setH100w(Integer H100w) {
		setAttrVal("H100w", H100w);
	}
	/**
	 * 你在月经期是否经常有焦躁情绪？
	 * @return Integer
	 */
	public Integer getH101w() {
		return ((Integer) getAttrVal("H101w"));
	}	
	/**
	 * 你在月经期是否经常有焦躁情绪？
	 * @param H101w
	 */
	public void setH101w(Integer H101w) {
		setAttrVal("H101w", H101w);
	}
	/**
	 * 你是否经常因白带（阴道白色粘液）异常而烦恼？
	 * @return Integer
	 */
	public Integer getH102w() {
		return ((Integer) getAttrVal("H102w"));
	}	
	/**
	 * 你是否经常因白带（阴道白色粘液）异常而烦恼？
	 * @param H102w
	 */
	public void setH102w(Integer H102w) {
		setAttrVal("H102w", H102w);
	}
	/**
	 * 你是否每天夜里因小便起床？
	 * @return Integer
	 */
	public Integer getH103() {
		return ((Integer) getAttrVal("H103"));
	}	
	/**
	 * 你是否每天夜里因小便起床？
	 * @param H103
	 */
	public void setH103(Integer H103) {
		setAttrVal("H103", H103);
	}
	/**
	 * 你是否经常白天小便次数频繁？
	 * @return Integer
	 */
	public Integer getH104() {
		return ((Integer) getAttrVal("H104"));
	}	
	/**
	 * 你是否经常白天小便次数频繁？
	 * @param H104
	 */
	public void setH104(Integer H104) {
		setAttrVal("H104", H104);
	}
	/**
	 * 你是否小便时经常有烧灼感（火烧样的疼痛）？
	 * @return Integer
	 */
	public Integer getH105() {
		return ((Integer) getAttrVal("H105"));
	}	
	/**
	 * 你是否小便时经常有烧灼感（火烧样的疼痛）？
	 * @param H105
	 */
	public void setH105(Integer H105) {
		setAttrVal("H105", H105);
	}
	/**
	 * 你是否有时有尿失控（不能由意识来控制排尿）？
	 * @return Integer
	 */
	public Integer getH106() {
		return ((Integer) getAttrVal("H106"));
	}	
	/**
	 * 你是否有时有尿失控（不能由意识来控制排尿）？
	 * @param H106
	 */
	public void setH106(Integer H106) {
		setAttrVal("H106", H106);
	}
	/**
	 * 是否医生说过你的肾、膀胱有病？
	 * @return Integer
	 */
	public Integer getH107() {
		return ((Integer) getAttrVal("H107"));
	}	
	/**
	 * 是否医生说过你的肾、膀胱有病？
	 * @param H107
	 */
	public void setH107(Integer H107) {
		setAttrVal("H107", H107);
	}
	/**
	 * 你是否经常感到一阵一阵很疲劳？
	 * @return Integer
	 */
	public Integer getI108() {
		return ((Integer) getAttrVal("I108"));
	}	
	/**
	 * 你是否经常感到一阵一阵很疲劳？
	 * @param I108
	 */
	public void setI108(Integer I108) {
		setAttrVal("I108", I108);
	}
	/**
	 * 是否工作使你感到筋疲力竭？
	 * @return Integer
	 */
	public Integer getI109() {
		return ((Integer) getAttrVal("I109"));
	}	
	/**
	 * 是否工作使你感到筋疲力竭？
	 * @param I109
	 */
	public void setI109(Integer I109) {
		setAttrVal("I109", I109);
	}
	/**
	 * 你是否经常早晨起床后即感到疲倦和筋疲力尽？
	 * @return Integer
	 */
	public Integer getI110() {
		return ((Integer) getAttrVal("I110"));
	}	
	/**
	 * 你是否经常早晨起床后即感到疲倦和筋疲力尽？
	 * @param I110
	 */
	public void setI110(Integer I110) {
		setAttrVal("I110", I110);
	}
	/**
	 * 你是否稍做一点工作就感到累？
	 * @return Integer
	 */
	public Integer getI111() {
		return ((Integer) getAttrVal("I111"));
	}	
	/**
	 * 你是否稍做一点工作就感到累？
	 * @param I111
	 */
	public void setI111(Integer I111) {
		setAttrVal("I111", I111);
	}
	/**
	 * 你是否经常因累而吃不下饭？
	 * @return Integer
	 */
	public Integer getI112() {
		return ((Integer) getAttrVal("I112"));
	}	
	/**
	 * 你是否经常因累而吃不下饭？
	 * @param I112
	 */
	public void setI112(Integer I112) {
		setAttrVal("I112", I112);
	}
	/**
	 * 你是否有严重的神经衰弱？
	 * @return Integer
	 */
	public Integer getI113() {
		return ((Integer) getAttrVal("I113"));
	}	
	/**
	 * 你是否有严重的神经衰弱？
	 * @param I113
	 */
	public void setI113(Integer I113) {
		setAttrVal("I113", I113);
	}
	/**
	 * 你的家属中是否有患神经衰弱的人？
	 * @return Integer
	 */
	public Integer getI114() {
		return ((Integer) getAttrVal("I114"));
	}	
	/**
	 * 你的家属中是否有患神经衰弱的人？
	 * @param I114
	 */
	public void setI114(Integer I114) {
		setAttrVal("I114", I114);
	}
	/**
	 * 你是否经常患病？
	 * @return Integer
	 */
	public Integer getJ115() {
		return ((Integer) getAttrVal("J115"));
	}	
	/**
	 * 你是否经常患病？
	 * @param J115
	 */
	public void setJ115(Integer J115) {
		setAttrVal("J115", J115);
	}
	/**
	 * 你是否经常由于患病而卧床？
	 * @return Integer
	 */
	public Integer getJ116() {
		return ((Integer) getAttrVal("J116"));
	}	
	/**
	 * 你是否经常由于患病而卧床？
	 * @param J116
	 */
	public void setJ116(Integer J116) {
		setAttrVal("J116", J116);
	}
	/**
	 * 你是否总是健康不良？
	 * @return Integer
	 */
	public Integer getJ117() {
		return ((Integer) getAttrVal("J117"));
	}	
	/**
	 * 你是否总是健康不良？
	 * @param J117
	 */
	public void setJ117(Integer J117) {
		setAttrVal("J117", J117);
	}
	/**
	 * 是否别人认为你体弱多病？
	 * @return Integer
	 */
	public Integer getJ118() {
		return ((Integer) getAttrVal("J118"));
	}	
	/**
	 * 是否别人认为你体弱多病？
	 * @param J118
	 */
	public void setJ118(Integer J118) {
		setAttrVal("J118", J118);
	}
	/**
	 * 你的家属中是否有患病的人？
	 * @return Integer
	 */
	public Integer getJ119() {
		return ((Integer) getAttrVal("J119"));
	}	
	/**
	 * 你的家属中是否有患病的人？
	 * @param J119
	 */
	public void setJ119(Integer J119) {
		setAttrVal("J119", J119);
	}
	/**
	 * 你是否曾经因严重的疼痛而不能工作？
	 * @return Integer
	 */
	public Integer getJ120() {
		return ((Integer) getAttrVal("J120"));
	}	
	/**
	 * 你是否曾经因严重的疼痛而不能工作？
	 * @param J120
	 */
	public void setJ120(Integer J120) {
		setAttrVal("J120", J120);
	}
	/**
	 * 你是否总是因为担心自己的健康而受不了？
	 * @return Integer
	 */
	public Integer getJ121() {
		return ((Integer) getAttrVal("J121"));
	}	
	/**
	 * 你是否总是因为担心自己的健康而受不了？
	 * @param J121
	 */
	public void setJ121(Integer J121) {
		setAttrVal("J121", J121);
	}
	/**
	 * 你是否总是有病而且不愉快？
	 * @return Integer
	 */
	public Integer getJ122() {
		return ((Integer) getAttrVal("J122"));
	}	
	/**
	 * 你是否总是有病而且不愉快？
	 * @param J122
	 */
	public void setJ122(Integer J122) {
		setAttrVal("J122", J122);
	}
	/**
	 * 你是否经常由于健康不好而感到不幸？
	 * @return Integer
	 */
	public Integer getJ123() {
		return ((Integer) getAttrVal("J123"));
	}	
	/**
	 * 你是否经常由于健康不好而感到不幸？
	 * @param J123
	 */
	public void setJ123(Integer J123) {
		setAttrVal("J123", J123);
	}
	/**
	 * 你得过猩红热吗？
	 * @return Integer
	 */
	public Integer getK124() {
		return ((Integer) getAttrVal("K124"));
	}	
	/**
	 * 你得过猩红热吗？
	 * @param K124
	 */
	public void setK124(Integer K124) {
		setAttrVal("K124", K124);
	}
	/**
	 * 你小时候是否得过风湿热、四肢疼痛？
	 * @return Integer
	 */
	public Integer getK125() {
		return ((Integer) getAttrVal("K125"));
	}	
	/**
	 * 你小时候是否得过风湿热、四肢疼痛？
	 * @param K125
	 */
	public void setK125(Integer K125) {
		setAttrVal("K125", K125);
	}
	/**
	 * 你曾患过疟疾吗？
	 * @return Integer
	 */
	public Integer getK126() {
		return ((Integer) getAttrVal("K126"));
	}	
	/**
	 * 你曾患过疟疾吗？
	 * @param K126
	 */
	public void setK126(Integer K126) {
		setAttrVal("K126", K126);
	}
	/**
	 * 你由于严重贫血而接受过治疗吗？
	 * @return Integer
	 */
	public Integer getK127() {
		return ((Integer) getAttrVal("K127"));
	}	
	/**
	 * 你由于严重贫血而接受过治疗吗？
	 * @param K127
	 */
	public void setK127(Integer K127) {
		setAttrVal("K127", K127);
	}
	/**
	 * 你接受过性病治疗吗？
	 * @return Integer
	 */
	public Integer getK128() {
		return ((Integer) getAttrVal("K128"));
	}	
	/**
	 * 你接受过性病治疗吗？
	 * @param K128
	 */
	public void setK128(Integer K128) {
		setAttrVal("K128", K128);
	}
	/**
	 * 你是否有糖尿病？
	 * @return Integer
	 */
	public Integer getK129() {
		return ((Integer) getAttrVal("K129"));
	}	
	/**
	 * 你是否有糖尿病？
	 * @param K129
	 */
	public void setK129(Integer K129) {
		setAttrVal("K129", K129);
	}
	/**
	 * 是否医生曾说过你有甲状腺肿（粗脖子病）？
	 * @return Integer
	 */
	public Integer getK130() {
		return ((Integer) getAttrVal("K130"));
	}	
	/**
	 * 是否医生曾说过你有甲状腺肿（粗脖子病）？
	 * @param K130
	 */
	public void setK130(Integer K130) {
		setAttrVal("K130", K130);
	}
	/**
	 * 你是否接受过肿瘤或癌的治疗？
	 * @return Integer
	 */
	public Integer getK131() {
		return ((Integer) getAttrVal("K131"));
	}	
	/**
	 * 你是否接受过肿瘤或癌的治疗？
	 * @param K131
	 */
	public void setK131(Integer K131) {
		setAttrVal("K131", K131);
	}
	/**
	 * 你是否有什么慢性病（或曾接受过原子辐射）？
	 * @return Integer
	 */
	public Integer getK132() {
		return ((Integer) getAttrVal("K132"));
	}	
	/**
	 * 你是否有什么慢性病（或曾接受过原子辐射）？
	 * @param K132
	 */
	public void setK132(Integer K132) {
		setAttrVal("K132", K132);
	}
	/**
	 * 你是否过瘦（体重减轻）？
	 * @return Integer
	 */
	public Integer getK133() {
		return ((Integer) getAttrVal("K133"));
	}	
	/**
	 * 你是否过瘦（体重减轻）？
	 * @param K133
	 */
	public void setK133(Integer K133) {
		setAttrVal("K133", K133);
	}
	/**
	 * 你是否过胖（体重增加）？
	 * @return Integer
	 */
	public Integer getK134() {
		return ((Integer) getAttrVal("K134"));
	}	
	/**
	 * 你是否过胖（体重增加）？
	 * @param K134
	 */
	public void setK134(Integer K134) {
		setAttrVal("K134", K134);
	}
	/**
	 * 是否有医生说过你有腿部静脉曲张（腿部青筋暴露）？
	 * @return Integer
	 */
	public Integer getK135() {
		return ((Integer) getAttrVal("K135"));
	}	
	/**
	 * 是否有医生说过你有腿部静脉曲张（腿部青筋暴露）？
	 * @param K135
	 */
	public void setK135(Integer K135) {
		setAttrVal("K135", K135);
	}
	/**
	 * 你是否住院做过手术？
	 * @return Integer
	 */
	public Integer getK136() {
		return ((Integer) getAttrVal("K136"));
	}	
	/**
	 * 你是否住院做过手术？
	 * @param K136
	 */
	public void setK136(Integer K136) {
		setAttrVal("K136", K136);
	}
	/**
	 * 你曾有过严重的外伤吗？
	 * @return Integer
	 */
	public Integer getK137() {
		return ((Integer) getAttrVal("K137"));
	}	
	/**
	 * 你曾有过严重的外伤吗？
	 * @param K137
	 */
	public void setK137(Integer K137) {
		setAttrVal("K137", K137);
	}
	/**
	 * 你是否经常发生小的事故或外伤？
	 * @return Integer
	 */
	public Integer getK138() {
		return ((Integer) getAttrVal("K138"));
	}	
	/**
	 * 你是否经常发生小的事故或外伤？
	 * @param K138
	 */
	public void setK138(Integer K138) {
		setAttrVal("K138", K138);
	}
	/**
	 * 你是否有入睡很困难或睡眠不深易醒（或经常做梦）的现象？
	 * @return Integer
	 */
	public Integer getL139() {
		return ((Integer) getAttrVal("L139"));
	}	
	/**
	 * 你是否有入睡很困难或睡眠不深易醒（或经常做梦）的现象？
	 * @param L139
	 */
	public void setL139(Integer L139) {
		setAttrVal("L139", L139);
	}
	/**
	 * 你是否不能做到每天有规律地放松一下（休息）？
	 * @return Integer
	 */
	public Integer getL140() {
		return ((Integer) getAttrVal("L140"));
	}	
	/**
	 * 你是否不能做到每天有规律地放松一下（休息）？
	 * @param L140
	 */
	public void setL140(Integer L140) {
		setAttrVal("L140", L140);
	}
	/**
	 * 你是否不容易做到每天有规律地锻炼？
	 * @return Integer
	 */
	public Integer getL141() {
		return ((Integer) getAttrVal("L141"));
	}	
	/**
	 * 你是否不容易做到每天有规律地锻炼？
	 * @param L141
	 */
	public void setL141(Integer L141) {
		setAttrVal("L141", L141);
	}
	/**
	 * 你是否每天吸20支以上的纸烟？
	 * @return Integer
	 */
	public Integer getL142() {
		return ((Integer) getAttrVal("L142"));
	}	
	/**
	 * 你是否每天吸20支以上的纸烟？
	 * @param L142
	 */
	public void setL142(Integer L142) {
		setAttrVal("L142", L142);
	}
	/**
	 * 你是否喝茶或喝咖啡比一般的人要多？
	 * @return Integer
	 */
	public Integer getL143() {
		return ((Integer) getAttrVal("L143"));
	}	
	/**
	 * 你是否喝茶或喝咖啡比一般的人要多？
	 * @param L143
	 */
	public void setL143(Integer L143) {
		setAttrVal("L143", L143);
	}
	/**
	 * 你是否每天喝两次以上的白酒？
	 * @return Integer
	 */
	public Integer getL144() {
		return ((Integer) getAttrVal("L144"));
	}	
	/**
	 * 你是否每天喝两次以上的白酒？
	 * @param L144
	 */
	public void setL144(Integer L144) {
		setAttrVal("L144", L144);
	}
	/**
	 * 当你考试或被提问时是否出汗很多或颤抖的很厉害？
	 * @return Integer
	 */
	public Integer getM145() {
		return ((Integer) getAttrVal("M145"));
	}	
	/**
	 * 当你考试或被提问时是否出汗很多或颤抖的很厉害？
	 * @param M145
	 */
	public void setM145(Integer M145) {
		setAttrVal("M145", M145);
	}
	/**
	 * 接近你的主管上级时是否紧张和发抖？
	 * @return Integer
	 */
	public Integer getM146() {
		return ((Integer) getAttrVal("M146"));
	}	
	/**
	 * 接近你的主管上级时是否紧张和发抖？
	 * @param M146
	 */
	public void setM146(Integer M146) {
		setAttrVal("M146", M146);
	}
	/**
	 * 当你的上级看着你工作时，你是否不知所措？
	 * @return Integer
	 */
	public Integer getM147() {
		return ((Integer) getAttrVal("M147"));
	}	
	/**
	 * 当你的上级看着你工作时，你是否不知所措？
	 * @param M147
	 */
	public void setM147(Integer M147) {
		setAttrVal("M147", M147);
	}
	/**
	 * 当必须快速做事情时，你是否有头脑完全混乱的现象？
	 * @return Integer
	 */
	public Integer getM148() {
		return ((Integer) getAttrVal("M148"));
	}	
	/**
	 * 当必须快速做事情时，你是否有头脑完全混乱的现象？
	 * @param M148
	 */
	public void setM148(Integer M148) {
		setAttrVal("M148", M148);
	}
	/**
	 * 为了避免出错，你做事必须很慢吗？
	 * @return Integer
	 */
	public Integer getM149() {
		return ((Integer) getAttrVal("M149"));
	}	
	/**
	 * 为了避免出错，你做事必须很慢吗？
	 * @param M149
	 */
	public void setM149(Integer M149) {
		setAttrVal("M149", M149);
	}
	/**
	 * 你经常把指令或意图体会（理解）错吗？
	 * @return Integer
	 */
	public Integer getM150() {
		return ((Integer) getAttrVal("M150"));
	}	
	/**
	 * 你经常把指令或意图体会（理解）错吗？
	 * @param M150
	 */
	public void setM150(Integer M150) {
		setAttrVal("M150", M150);
	}
	/**
	 * 是否生疏的人或场所使你感到害怕？
	 * @return Integer
	 */
	public Integer getM151() {
		return ((Integer) getAttrVal("M151"));
	}	
	/**
	 * 是否生疏的人或场所使你感到害怕？
	 * @param M151
	 */
	public void setM151(Integer M151) {
		setAttrVal("M151", M151);
	}
	/**
	 * 身边没有熟人时你是否因孤单而恐慌？
	 * @return Integer
	 */
	public Integer getM152() {
		return ((Integer) getAttrVal("M152"));
	}	
	/**
	 * 身边没有熟人时你是否因孤单而恐慌？
	 * @param M152
	 */
	public void setM152(Integer M152) {
		setAttrVal("M152", M152);
	}
	/**
	 * 你是否总是难以下决心（犹豫不决）？
	 * @return Integer
	 */
	public Integer getM153() {
		return ((Integer) getAttrVal("M153"));
	}	
	/**
	 * 你是否总是难以下决心（犹豫不决）？
	 * @param M153
	 */
	public void setM153(Integer M153) {
		setAttrVal("M153", M153);
	}
	/**
	 * 你是否总是希望有人在你身边给你出主意？
	 * @return Integer
	 */
	public Integer getM154() {
		return ((Integer) getAttrVal("M154"));
	}	
	/**
	 * 你是否总是希望有人在你身边给你出主意？
	 * @param M154
	 */
	public void setM154(Integer M154) {
		setAttrVal("M154", M154);
	}
	/**
	 * 别人认为你是一个很笨的人吗？
	 * @return Integer
	 */
	public Integer getM155() {
		return ((Integer) getAttrVal("M155"));
	}	
	/**
	 * 别人认为你是一个很笨的人吗？
	 * @param M155
	 */
	public void setM155(Integer M155) {
		setAttrVal("M155", M155);
	}
	/**
	 * 除了在你自己家以外，在其它任何地方吃东西都感到烦扰吗？
	 * @return Integer
	 */
	public Integer getM156() {
		return ((Integer) getAttrVal("M156"));
	}	
	/**
	 * 除了在你自己家以外，在其它任何地方吃东西都感到烦扰吗？
	 * @param M156
	 */
	public void setM156(Integer M156) {
		setAttrVal("M156", M156);
	}
	/**
	 * 你在聚会中也感到孤独和悲伤吗？
	 * @return Integer
	 */
	public Integer getN157() {
		return ((Integer) getAttrVal("N157"));
	}	
	/**
	 * 你在聚会中也感到孤独和悲伤吗？
	 * @param N157
	 */
	public void setN157(Integer N157) {
		setAttrVal("N157", N157);
	}
	/**
	 * 你是否经常感到不愉快和情绪抑郁（情绪低落）？
	 * @return Integer
	 */
	public Integer getN158() {
		return ((Integer) getAttrVal("N158"));
	}	
	/**
	 * 你是否经常感到不愉快和情绪抑郁（情绪低落）？
	 * @param N158
	 */
	public void setN158(Integer N158) {
		setAttrVal("N158", N158);
	}
	/**
	 * 你是否经常哭？
	 * @return Integer
	 */
	public Integer getN159() {
		return ((Integer) getAttrVal("N159"));
	}	
	/**
	 * 你是否经常哭？
	 * @param N159
	 */
	public void setN159(Integer N159) {
		setAttrVal("N159", N159);
	}
	/**
	 * 你是否总是感到凄惨与沮丧（灰心失望）？
	 * @return Integer
	 */
	public Integer getN160() {
		return ((Integer) getAttrVal("N160"));
	}	
	/**
	 * 你是否总是感到凄惨与沮丧（灰心失望）？
	 * @param N160
	 */
	public void setN160(Integer N160) {
		setAttrVal("N160", N160);
	}
	/**
	 * 是否你对生活感到完全绝望？
	 * @return Integer
	 */
	public Integer getN161() {
		return ((Integer) getAttrVal("N161"));
	}	
	/**
	 * 是否你对生活感到完全绝望？
	 * @param N161
	 */
	public void setN161(Integer N161) {
		setAttrVal("N161", N161);
	}
	/**
	 * 你是否经常想死（一死了事）？
	 * @return Integer
	 */
	public Integer getN162() {
		return ((Integer) getAttrVal("N162"));
	}	
	/**
	 * 你是否经常想死（一死了事）？
	 * @param N162
	 */
	public void setN162(Integer N162) {
		setAttrVal("N162", N162);
	}
	/**
	 * 你是否经常烦恼（愁眉不展）？
	 * @return Integer
	 */
	public Integer getO163() {
		return ((Integer) getAttrVal("O163"));
	}	
	/**
	 * 你是否经常烦恼（愁眉不展）？
	 * @param O163
	 */
	public void setO163(Integer O163) {
		setAttrVal("O163", O163);
	}
	/**
	 * 你的家属中是否有愁眉不展的人？
	 * @return Integer
	 */
	public Integer getO164() {
		return ((Integer) getAttrVal("O164"));
	}	
	/**
	 * 你的家属中是否有愁眉不展的人？
	 * @param O164
	 */
	public void setO164(Integer O164) {
		setAttrVal("O164", O164);
	}
	/**
	 * 是否稍遇任何一件小事都使你紧张和疲惫？
	 * @return Integer
	 */
	public Integer getO165() {
		return ((Integer) getAttrVal("O165"));
	}	
	/**
	 * 是否稍遇任何一件小事都使你紧张和疲惫？
	 * @param O165
	 */
	public void setO165(Integer O165) {
		setAttrVal("O165", O165);
	}
	/**
	 * 是否别人认为你是一个神经质（紧张不安，易激动）的人？
	 * @return Integer
	 */
	public Integer getO166() {
		return ((Integer) getAttrVal("O166"));
	}	
	/**
	 * 是否别人认为你是一个神经质（紧张不安，易激动）的人？
	 * @param O166
	 */
	public void setO166(Integer O166) {
		setAttrVal("O166", O166);
	}
	/**
	 * 你的家属中是否有神经质的人？
	 * @return Integer
	 */
	public Integer getO167() {
		return ((Integer) getAttrVal("O167"));
	}	
	/**
	 * 你的家属中是否有神经质的人？
	 * @param O167
	 */
	public void setO167(Integer O167) {
		setAttrVal("O167", O167);
	}
	/**
	 * 你曾患过精神崩溃吗？
	 * @return Integer
	 */
	public Integer getO168() {
		return ((Integer) getAttrVal("O168"));
	}	
	/**
	 * 你曾患过精神崩溃吗？
	 * @param O168
	 */
	public void setO168(Integer O168) {
		setAttrVal("O168", O168);
	}
	/**
	 * 你的家属中曾有过精神崩溃的人吗？
	 * @return Integer
	 */
	public Integer getO169() {
		return ((Integer) getAttrVal("O169"));
	}	
	/**
	 * 你的家属中曾有过精神崩溃的人吗？
	 * @param O169
	 */
	public void setO169(Integer O169) {
		setAttrVal("O169", O169);
	}
	/**
	 * 你在精神病院看过病吗（因为你精神方面的问题）？
	 * @return Integer
	 */
	public Integer getO170() {
		return ((Integer) getAttrVal("O170"));
	}	
	/**
	 * 你在精神病院看过病吗（因为你精神方面的问题）？
	 * @param O170
	 */
	public void setO170(Integer O170) {
		setAttrVal("O170", O170);
	}
	/**
	 * 你的家属中是否有人到精神病院看过病（因为精神方面的问题）？
	 * @return Integer
	 */
	public Integer getO171() {
		return ((Integer) getAttrVal("O171"));
	}	
	/**
	 * 你的家属中是否有人到精神病院看过病（因为精神方面的问题）？
	 * @param O171
	 */
	public void setO171(Integer O171) {
		setAttrVal("O171", O171);
	}
	/**
	 * 你是否经常害羞和神经过敏？
	 * @return Integer
	 */
	public Integer getP172() {
		return ((Integer) getAttrVal("P172"));
	}	
	/**
	 * 你是否经常害羞和神经过敏？
	 * @param P172
	 */
	public void setP172(Integer P172) {
		setAttrVal("P172", P172);
	}
	/**
	 * 你的家属中是否有害羞和神经过敏的人？
	 * @return Integer
	 */
	public Integer getP173() {
		return ((Integer) getAttrVal("P173"));
	}	
	/**
	 * 你的家属中是否有害羞和神经过敏的人？
	 * @param P173
	 */
	public void setP173(Integer P173) {
		setAttrVal("P173", P173);
	}
	/**
	 * 是否你的感情容易受到伤害？
	 * @return Integer
	 */
	public Integer getP174() {
		return ((Integer) getAttrVal("P174"));
	}	
	/**
	 * 是否你的感情容易受到伤害？
	 * @param P174
	 */
	public void setP174(Integer P174) {
		setAttrVal("P174", P174);
	}
	/**
	 * 是否你在受到批评时总是心烦意乱？
	 * @return Integer
	 */
	public Integer getP175() {
		return ((Integer) getAttrVal("P175"));
	}	
	/**
	 * 是否你在受到批评时总是心烦意乱？
	 * @param P175
	 */
	public void setP175(Integer P175) {
		setAttrVal("P175", P175);
	}
	/**
	 * 别人认为你是爱挑剔的人吗？
	 * @return Integer
	 */
	public Integer getP176() {
		return ((Integer) getAttrVal("P176"));
	}	
	/**
	 * 别人认为你是爱挑剔的人吗？
	 * @param P176
	 */
	public void setP176(Integer P176) {
		setAttrVal("P176", P176);
	}
	/**
	 * 你是否经常被人误解？
	 * @return Integer
	 */
	public Integer getP177() {
		return ((Integer) getAttrVal("P177"));
	}	
	/**
	 * 你是否经常被人误解？
	 * @param P177
	 */
	public void setP177(Integer P177) {
		setAttrVal("P177", P177);
	}
	/**
	 * 你即使对朋友也必须存戒心吗（不放松警惕）？
	 * @return Integer
	 */
	public Integer getQ178() {
		return ((Integer) getAttrVal("Q178"));
	}	
	/**
	 * 你即使对朋友也必须存戒心吗（不放松警惕）？
	 * @param Q178
	 */
	public void setQ178(Integer Q178) {
		setAttrVal("Q178", Q178);
	}
	/**
	 * 你是否总是凭一时冲动做事情？
	 * @return Integer
	 */
	public Integer getQ179() {
		return ((Integer) getAttrVal("Q179"));
	}	
	/**
	 * 你是否总是凭一时冲动做事情？
	 * @param Q179
	 */
	public void setQ179(Integer Q179) {
		setAttrVal("Q179", Q179);
	}
	/**
	 * 你是否容易烦恼和激怒？
	 * @return Integer
	 */
	public Integer getQ180() {
		return ((Integer) getAttrVal("Q180"));
	}	
	/**
	 * 你是否容易烦恼和激怒？
	 * @param Q180
	 */
	public void setQ180(Integer Q180) {
		setAttrVal("Q180", Q180);
	}
	/**
	 * 你若不持续克制自己精神就垮了吗？
	 * @return Integer
	 */
	public Integer getQ181() {
		return ((Integer) getAttrVal("Q181"));
	}	
	/**
	 * 你若不持续克制自己精神就垮了吗？
	 * @param Q181
	 */
	public void setQ181(Integer Q181) {
		setAttrVal("Q181", Q181);
	}
	/**
	 * 是否一点不快就使你紧张和发脾气？
	 * @return Integer
	 */
	public Integer getQ182() {
		return ((Integer) getAttrVal("Q182"));
	}	
	/**
	 * 是否一点不快就使你紧张和发脾气？
	 * @param Q182
	 */
	public void setQ182(Integer Q182) {
		setAttrVal("Q182", Q182);
	}
	/**
	 * 在别人支使你时是否易生气？
	 * @return Integer
	 */
	public Integer getQ183() {
		return ((Integer) getAttrVal("Q183"));
	}	
	/**
	 * 在别人支使你时是否易生气？
	 * @param Q183
	 */
	public void setQ183(Integer Q183) {
		setAttrVal("Q183", Q183);
	}
	/**
	 * 别人常使你不快和激怒你吗？
	 * @return Integer
	 */
	public Integer getQ184() {
		return ((Integer) getAttrVal("Q184"));
	}	
	/**
	 * 别人常使你不快和激怒你吗？
	 * @param Q184
	 */
	public void setQ184(Integer Q184) {
		setAttrVal("Q184", Q184);
	}
	/**
	 * 当你不能马上得到你所需要的东西时就发脾气吗？
	 * @return Integer
	 */
	public Integer getQ185() {
		return ((Integer) getAttrVal("Q185"));
	}	
	/**
	 * 当你不能马上得到你所需要的东西时就发脾气吗？
	 * @param Q185
	 */
	public void setQ185(Integer Q185) {
		setAttrVal("Q185", Q185);
	}
	/**
	 * 你是否经常大发脾气？
	 * @return Integer
	 */
	public Integer getQ186() {
		return ((Integer) getAttrVal("Q186"));
	}	
	/**
	 * 你是否经常大发脾气？
	 * @param Q186
	 */
	public void setQ186(Integer Q186) {
		setAttrVal("Q186", Q186);
	}
	/**
	 * 你是否经常发抖和战栗？
	 * @return Integer
	 */
	public Integer getR187() {
		return ((Integer) getAttrVal("R187"));
	}	
	/**
	 * 你是否经常发抖和战栗？
	 * @param R187
	 */
	public void setR187(Integer R187) {
		setAttrVal("R187", R187);
	}
	/**
	 * 你是否经常紧张焦急？
	 * @return Integer
	 */
	public Integer getR188() {
		return ((Integer) getAttrVal("R188"));
	}	
	/**
	 * 你是否经常紧张焦急？
	 * @param R188
	 */
	public void setR188(Integer R188) {
		setAttrVal("R188", R188);
	}
	/**
	 * 你是否会被突然的声音吓一大跳（跳起或发抖得厉害）？
	 * @return Integer
	 */
	public Integer getR189() {
		return ((Integer) getAttrVal("R189"));
	}	
	/**
	 * 你是否会被突然的声音吓一大跳（跳起或发抖得厉害）？
	 * @param R189
	 */
	public void setR189(Integer R189) {
		setAttrVal("R189", R189);
	}
	/**
	 * 是否不管何时，当别人大声对你时，你都被吓得发抖和发软？
	 * @return Integer
	 */
	public Integer getR190() {
		return ((Integer) getAttrVal("R190"));
	}	
	/**
	 * 是否不管何时，当别人大声对你时，你都被吓得发抖和发软？
	 * @param R190
	 */
	public void setR190(Integer R190) {
		setAttrVal("R190", R190);
	}
	/**
	 * 你对夜间突然的动静是否感到恐惧（害怕）？
	 * @return Integer
	 */
	public Integer getR191() {
		return ((Integer) getAttrVal("R191"));
	}	
	/**
	 * 你对夜间突然的动静是否感到恐惧（害怕）？
	 * @param R191
	 */
	public void setR191(Integer R191) {
		setAttrVal("R191", R191);
	}
	/**
	 * 你是否经常因恶梦而惊醒？
	 * @return Integer
	 */
	public Integer getR192() {
		return ((Integer) getAttrVal("R192"));
	}	
	/**
	 * 你是否经常因恶梦而惊醒？
	 * @param R192
	 */
	public void setR192(Integer R192) {
		setAttrVal("R192", R192);
	}
	/**
	 * 你是否头脑中经常反复出现某种恐怖（可怕的）想法？
	 * @return Integer
	 */
	public Integer getR193() {
		return ((Integer) getAttrVal("R193"));
	}	
	/**
	 * 你是否头脑中经常反复出现某种恐怖（可怕的）想法？
	 * @param R193
	 */
	public void setR193(Integer R193) {
		setAttrVal("R193", R193);
	}
	/**
	 * 你是否常常毫无理由地突然感到畏惧（害怕）？
	 * @return Integer
	 */
	public Integer getR194() {
		return ((Integer) getAttrVal("R194"));
	}	
	/**
	 * 你是否常常毫无理由地突然感到畏惧（害怕）？
	 * @param R194
	 */
	public void setR194(Integer R194) {
		setAttrVal("R194", R194);
	}
	/**
	 * 你是否经常有突然出冷汗的情况？
	 * @return Integer
	 */
	public Integer getR195() {
		return ((Integer) getAttrVal("R195"));
	}	
	/**
	 * 你是否经常有突然出冷汗的情况？
	 * @param R195
	 */
	public void setR195(Integer R195) {
		setAttrVal("R195", R195);
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
		return "Id_pecmi";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pecmi";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeCmiDODesc.class);
	}
	
}