package iih.bl.st.ip.s.bp;

import iih.ci.mrfp.cimrfpdto.d.CiMrFpSugDTO;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpXYDIDTO;
import iih.ci.mrfp.cmis.d.CiMrFpMsgDTO;
import iih.mi.biz.dto.d.MedicaluploadDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import iih.ci.mrfp.mrfpxml.d.Address;
import iih.ci.common.AddressAnalysis.AddressAnalysis;


/**
 * 病历信息转化
 * @author yangyang
 * @Date 2018-05-24
 */
public class XUrbanMedicalDataProcess extends AbstractMedicalDataProcess {

	@SuppressWarnings("unchecked")
	@Override
	public MedicaluploadDTO process(CiMrFpMsgDTO ciMrFpMsgDto) {
		MedicaluploadDTO medicalDto=new MedicaluploadDTO();  						//首页
		//DischargeDiagnosisDTO dischargeDiagnosisDTO = new DischargeDiagnosisDTO();  //诊断
		//OperationDTO operationDTO = new OperationDTO();  							//手术
		
		AddressAnalysis addrAnly = new AddressAnalysis();
		Address addr = new Address();
		String strAny = null;
		Integer intAny = null;
		FDouble doubleAny = null;
		FDateTime dateAny = null;
		FDateTime datetimeAny = null;
		
		//将ciMrFpMsgDto赋值给medicalDto，字段对应， 2018-05-25， nielisheng
		//row 10
		strAny = ciMrFpMsgDto.ciMrPat.getNo_inhos();
		medicalDto.setZyh(strAny); //住院号
		medicalDto.setHdsd00_11_118(ciMrFpMsgDto.ciMrPat.getName_org()); //医疗机构名称
		medicalDto.setHdsd00_11_119(ciMrFpMsgDto.ciMrPat.getId_org()); //医疗结构组织机构代码
		medicalDto.setHdsd00_11_117(ciMrFpMsgDto.ciMrPat.getSd_pay_method()); //医疗付费方式代码(参照CV07.10.005)
		medicalDto.setHdsd00_11_053(ciMrFpMsgDto.ciMrPat.getHealth_card_id()); //居民健康卡号
		intAny = ciMrFpMsgDto.ciMrPat.getN_times_inhospital();
		strAny = intAny == null ? "0" : intAny.toString();
		medicalDto.setHdsd00_11_139(strAny); //住院次数
		strAny = ciMrFpMsgDto.ciMrPat.getNo_inhos();
		medicalDto.setHdsd00_11_140(strAny); //HIS系统住院号
		medicalDto.setHdsd00_11_006(ciMrFpMsgDto.ciMrPat.getCode_amr_ip()); //病案号
		medicalDto.setHdsd00_11_110(ciMrFpMsgDto.ciMrPat.getName_pat()); //姓名
		medicalDto.setHdsd00_11_109(ciMrFpMsgDto.ciMrPat.getSd_sex()); //性别代码
		
		//row 20
		dateAny = ciMrFpMsgDto.ciMrPat.getDt_birth_pat();
		strAny = dateAny == null ? null : dateAny.toString();
		medicalDto.setHdsd00_11_014(strAny); //出生日期(YYYY-MM-DD)
		strAny = ciMrFpMsgDto.ciMrPat.getAge();
		strAny = strAny == null ? "0" : strAny.replace("岁", "");
		medicalDto.setHdsd00_11_079(strAny); //年龄(岁)
		medicalDto.setHdsd00_11_080(ciMrFpMsgDto.ciMrPat.getAge_month()); //年龄(月)
		strAny = ciMrFpMsgDto.ciMrPat.getSd_country();
		strAny = strAny == null ? "00" : strAny;
		medicalDto.setHdsd00_11_036(strAny); //国籍代码(参照E105-01)
		intAny = ciMrFpMsgDto.ciMrPat.getBirth_weight();
		strAny = intAny == null ? null : intAny.toString();
		medicalDto.setHdsd00_11_107(strAny); //新生儿出生体重(g)
		intAny = ciMrFpMsgDto.ciMrPat.getAddmission_weight();
		strAny = intAny == null ? null : intAny.toString();
		medicalDto.setHdsd00_11_108(strAny); //新生儿入院体重(g)
		addr = addrAnly.getDetailAdderss(ciMrFpMsgDto.ciMrPat.getAddr_born());
		medicalDto.setHdsd00_11_011(addr.getState()); //出生地-省(自治区、直辖市)
		medicalDto.setHdsd00_11_012(addr.getCity()); //出生地-市(地区、州)
		medicalDto.setHdsd00_11_013(addr.getCounty()); //出生地-县(区)
		addr = addrAnly.getDetailAdderss(ciMrFpMsgDto.ciMrPat.getAddr_origin());
		medicalDto.setHdsd00_11_051(addr.getState()); //籍贯-省(自治区、直辖市)

		//row 30
		medicalDto.setHdsd00_11_052(addr.getCity()); //籍贯-市(地区、州)
		medicalDto.setHdsd00_11_077(ciMrFpMsgDto.ciMrPat.getSd_nation()); //民族
		medicalDto.setHdsd00_11_049(ciMrFpMsgDto.ciMrPat.getSd_idtp()); //身份证件类别代码
		medicalDto.setHdsd00_11_048(ciMrFpMsgDto.ciMrPat.getId_code()); //患者身份证件号码
		medicalDto.setHdsd00_11_125(ciMrFpMsgDto.ciMrPat.getSd_occu()); //职业类别代码
		medicalDto.setHdsd00_11_050(ciMrFpMsgDto.ciMrPat.getSd_marry()); //婚姻状况代码
		
		addr = addrAnly.getDetailAdderss(ciMrFpMsgDto.ciMrPat.getAddr_now());
		medicalDto.setHdsd00_11_102(addr.getState()); //现住址-省(自治区、直辖市)
		medicalDto.setHdsd00_11_103(addr.getCity()); //现住址-市(地区、州)
		medicalDto.setHdsd00_11_104(addr.getCounty()); //现住址-县(区)
		medicalDto.setHdsd00_11_105(addr.getTownship()); //现住址-乡(镇、街道办事处)

		//row 40
		medicalDto.setHdsd00_11_100(addr.getStreetName()); //现住址-村(街、路、弄等)
		medicalDto.setHdsd00_11_101(addr.getHoseNumber()); //现住址-门牌号码
		medicalDto.setHdsd00_11_026(ciMrFpMsgDto.ciMrPat.getTel_addr_now()); //电话号码
		medicalDto.setHdsd00_11_106(ciMrFpMsgDto.ciMrPat.getZip_addr_now()); //现住址-邮政编码
		
		addr = addrAnly.getDetailAdderss(ciMrFpMsgDto.ciMrPat.getAddr_now());
		medicalDto.setHdsd00_11_043(addr.getState()); //户口地址-省(自治区、直辖市)
		medicalDto.setHdsd00_11_044(addr.getCity()); //户口地址-市(地区、州)
		medicalDto.setHdsd00_11_045(addr.getCounty()); //户口地址-县(区)
		medicalDto.setHdsd00_11_046(addr.getTownship()); //户口地址-乡(镇、街道办事处)
		medicalDto.setHdsd00_11_041(addr.getStreetName()); //户口地址-村(街、路、弄等)
		medicalDto.setHdsd00_11_042(addr.getHoseNumber()); //户口地址-门牌号码

		//row 50
		medicalDto.setHdsd00_11_047(ciMrFpMsgDto.ciMrPat.getZip_addr_cencus()); //户口地址-邮政编码
		medicalDto.setHdsd00_11_035(ciMrFpMsgDto.ciMrPat.getWorkunit()); //工作单位名称
		addr = addrAnly.getDetailAdderss(ciMrFpMsgDto.ciMrPat.getAddr_work());
		medicalDto.setHdsd00_11_029(addr.getState()); //工作单位地址-省(自治区、直辖市)
		medicalDto.setHdsd00_11_030(addr.getCity()); //工作单位地址-市(地区、州)
		medicalDto.setHdsd00_11_031(addr.getCounty()); //工作单位地址-县(区)
		medicalDto.setHdsd00_11_032(addr.getStreetName()); //工作单位地址-乡(镇、街道办事处)
		medicalDto.setHdsd00_11_027(addr.getTownship()); //工作单位地址-村(街、路、弄等)
		medicalDto.setHdsd00_11_028(addr.getHoseNumber()); //工作单位地址-门牌号码
		medicalDto.setHdsd00_11_034(ciMrFpMsgDto.ciMrPat.getDel_addr_work()); //工作单位电话号码
		medicalDto.setHdsd00_11_033(ciMrFpMsgDto.ciMrPat.getZip_addr_work()); //工作单位地址-邮政编码

		//row 60
		medicalDto.setHdsd00_11_065(ciMrFpMsgDto.ciMrPat.getName_cont()); //联系人姓名
		medicalDto.setHdsd00_11_066(ciMrFpMsgDto.ciMrPat.getSd_conttp()); //联系人与患者的关系代码
		addr = addrAnly.getDetailAdderss(ciMrFpMsgDto.ciMrPat.getAddr_cont());
		medicalDto.setHdsd00_11_060(addr.getState()); //联系人地址-省(自治区、直辖市)
		medicalDto.setHdsd00_11_061(addr.getCity()); //联系人地址-市(地区、州)
		medicalDto.setHdsd00_11_062(addr.getCounty()); //联系人地址-县(区)
		medicalDto.setHdsd00_11_063(addr.getTownship()); //联系人地址-乡(镇、街道办事处)
		medicalDto.setHdsd00_11_058(addr.getStreetName()); //联系人地址-村(街、路、弄等)
		medicalDto.setHdsd00_11_059(addr.getHoseNumber()); //联系人地址-门牌号码
		medicalDto.setHdsd00_11_064(ciMrFpMsgDto.ciMrPat.getTel_cont()); //联系人电话号码
		medicalDto.setHdsd00_11_086(ciMrFpMsgDto.ciMrPat.getSd_referalsrc()); //入院途径代码(参照CV09.00.403)

		//row 70
		datetimeAny = ciMrFpMsgDto.ciMrPat.getDt_end();
		strAny = datetimeAny == null ? null : datetimeAny.toString();
		medicalDto.setHdsd00_11_085(ciMrFpMsgDto.ciMrPat.getDt_acpt().toStdString()); //入院日期时间(YYYY-MM-DD)
		medicalDto.setHdsd00_11_084(ciMrFpMsgDto.ciMrPat.getName_dep_phyadm()); //入院科别（传输名称）
		medicalDto.setHdsd00_11_083(ciMrFpMsgDto.ciMrPat.getName_in_bed()); //入院病房（传输名称）
		medicalDto.setHdsd00_11_144(ciMrFpMsgDto.ciMrPat.getName_dep_trans()); //转科科别（传输名称）
		medicalDto.setHdsd00_11_019(strAny); //出院日期时间(YYYY-MM-DD)
		medicalDto.setHdsd00_11_018(ciMrFpMsgDto.ciMrPat.getName_dep_phydisc()); //出院科别（传输名称）
		medicalDto.setHdsd00_11_017(ciMrFpMsgDto.ciMrPat.getName_out_bed()); //出院病房（传输名称）

		intAny = ciMrFpMsgDto.ciMrPat.getHosdays();
		strAny = intAny == null ? "0" : intAny.toString();
		medicalDto.setHdsd00_11_087(strAny); //实际住院天数
		medicalDto.setHdsd00_11_076(ciMrFpMsgDto.ciMrPat.getName_outp_emer_di()); //门(急)诊诊断名称
		medicalDto.setHdsd00_11_075(ciMrFpMsgDto.ciMrPat.getSd_outp_emer_di()); //门(急)诊诊断疾病代码(参照ICD-10)
		
		//row 80
		//诊断
		medicalDto.setHdsd00_11_x01(ciMrFpMsgDto.ciMrPat.getNo_inhos()); //出院诊断信息, 格式见备注[1], varchar2(4000)
		medicalDto.setHdsd00_11_096(ciMrFpMsgDto.ciMrPat.getName_iioutreason()); //损伤中毒的外部原因
		medicalDto.setHdsd00_11_097(ciMrFpMsgDto.ciMrPat.getSd_iioutreason()); //损伤中毒的外部原因疾病编码(参照ICD-10)
		medicalDto.setHdsd00_11_010(ciMrFpMsgDto.ciMrPat.getName_dipathology()); //病理诊断名称
		medicalDto.setHdsd00_11_009(ciMrFpMsgDto.ciMrPat.getSd_dipathology()); //病理诊断疾病编码(参照ICD-10)
		medicalDto.setHdsd00_11_008(ciMrFpMsgDto.ciMrPat.getNum_patho()); //病理号
		strAny = ciMrFpMsgDto.ciMrPat.getId_drug_allergy();
		strAny = strAny == null ? "0" : strAny;
		medicalDto.setHdsd00_11_116(strAny); //药物过敏标志(1.是 2.否)
		medicalDto.setHdsd00_11_037(ciMrFpMsgDto.ciMrPat.getAllergic_drugs()); //过敏药物
		strAny = ciMrFpMsgDto.ciMrPat.getId_aut_dead_pat();
		strAny = strAny == null ? "0" : strAny;
		medicalDto.setHdsd00_11_095(strAny); //死亡患者尸检标志(1.是 2.否)
		medicalDto.setHdsd00_11_003(ciMrFpMsgDto.ciMrPat.getId_blood_type()); //ABO血型代码
		
		//row 90
		medicalDto.setHdsd00_11_004(ciMrFpMsgDto.ciMrPat.getId_rh_type()); //Rh血型代码(参照CV04.50.020)
		medicalDto.setHdsd00_11_056(ciMrFpMsgDto.ciMrPat.getDirofdept()); //科主任签名
		medicalDto.setHdsd00_11_137(ciMrFpMsgDto.ciMrPat.getName_zr_doc()); //主任(副主任)医师签名
		medicalDto.setHdsd00_11_138(ciMrFpMsgDto.ciMrPat.getName_zz_doc()); //主治医师签名
		medicalDto.setHdsd00_11_141(ciMrFpMsgDto.ciMrPat.getSd_zy_doc()); //住院医师签名
		medicalDto.setHdsd00_11_120(ciMrFpMsgDto.ciMrPat.getName_emp_nur()); //责任护士签名
		medicalDto.setHdsd00_11_054(ciMrFpMsgDto.ciMrPat.getName_learn_doc()); //进修医师签名
		medicalDto.setHdsd00_11_088(ciMrFpMsgDto.ciMrPat.getName_intern_doc()); //实习医师签名
		medicalDto.setHdsd00_11_005(ciMrFpMsgDto.ciMrPat.getName_coder()); //编码员签名
		medicalDto.setHdsd00_11_007(ciMrFpMsgDto.ciMrPat.getId_qom_record()); //病案质量代码(1.甲 2.乙 3.丙)
		
		//row 100
		//手术
		FDate dateAny2;
		dateAny2 = ciMrFpMsgDto.ciMrPat.getQc_date();
		strAny = dateAny == null ? null : dateAny2.toString();
		medicalDto.setHdsd00_11_128(ciMrFpMsgDto.ciMrPat.getName_qcp_doc()); //质控医师签名
		medicalDto.setHdsd00_11_126(ciMrFpMsgDto.ciMrPat.getName_qcp_nur()); //质控护士签名
		medicalDto.setHdsd00_11_127(strAny); //质控日期(YYYY-MM-DD)
		medicalDto.setHdsd00_11_x02(ciMrFpMsgDto.ciMrPat.getNo_inhos()); //手术及操作信息，格式见备注[2], varchar2(4000)
		medicalDto.setHdsd00_11_057(ciMrFpMsgDto.ciMrPat.getOut_hos_mode()); //离院方式代码(参照CV06.00.226)
		medicalDto.setHdsd00_11_078(ciMrFpMsgDto.ciMrPat.getName_med_in_1()); //拟接收医疗机构名称
		strAny = ciMrFpMsgDto.ciMrPat.getId_is_have_inhos_plan();
		strAny = strAny == null ? "0" : strAny;
		medicalDto.setHdsd00_11_015(strAny); //出院31天内再住院标志(1.是 2.否)
		medicalDto.setHdsd00_11_016(ciMrFpMsgDto.ciMrPat.getName_is_have_inhos_plan()); //出院31天内再住院目的
		
		intAny = ciMrFpMsgDto.ciMrPat.getComa_time_bef_inhos_days();
		strAny = intAny == null ? null : intAny.toString();
		medicalDto.setHdsd00_11_070(strAny); //颅脑损伤患者入院前昏迷时间-d
		intAny = ciMrFpMsgDto.ciMrPat.getComa_time_bef_inhos_hours();
		strAny = intAny == null ? null : intAny.toString();
		medicalDto.setHdsd00_11_071(strAny); //颅脑损伤患者入院前昏迷时间-h

		//row 110
		intAny = ciMrFpMsgDto.ciMrPat.getComa_time_bef_inhos_mins();
		strAny = intAny == null ? null : intAny.toString();
		medicalDto.setHdsd00_11_072(strAny); //颅脑损伤患者入院前昏迷时间-min
		intAny = ciMrFpMsgDto.ciMrPat.getComa_time_inhos_days();
		strAny = intAny == null ? null : intAny.toString();
		medicalDto.setHdsd00_11_067(strAny); //颅脑损伤患者入院后昏迷时间-d
		intAny = ciMrFpMsgDto.ciMrPat.getComa_time_inhos_hours();
		strAny = intAny == null ? null : intAny.toString();
		medicalDto.setHdsd00_11_068(strAny); //颅脑损伤患者入院后昏迷时间-h
		intAny = ciMrFpMsgDto.ciMrPat.getComa_time_inhos_mins();
		strAny = intAny == null ? null : intAny.toString();
		medicalDto.setHdsd00_11_069(strAny); //颅脑损伤患者入院后昏迷时间-min
		doubleAny = ciMrFpMsgDto.ciMrPat.getAmount();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_142(strAny); //住院总费用
		doubleAny = ciMrFpMsgDto.ciMrPat.getCms_spamount();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_143(strAny); //住院总费用-自付金额
		doubleAny = ciMrFpMsgDto.ciMrPat.getCms_gmsfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_147(strAny); //综合医疗服务类-一般医疗服务费
		doubleAny = ciMrFpMsgDto.ciMrPat.getCms_gtofee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_148(strAny); //综合医疗服务类-一般治疗操作费
		doubleAny = ciMrFpMsgDto.ciMrPat.getCms_nurfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_145(strAny); //综合医疗服务类-护理费
		doubleAny = ciMrFpMsgDto.ciMrPat.getCms_otherfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_146(strAny); //综合医疗服务类-其他费用

		//row 120
		doubleAny = ciMrFpMsgDto.ciMrPat.getDi_pdifee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_121(strAny); //诊断类-病理诊断费
		doubleAny = ciMrFpMsgDto.ciMrPat.getDi_ldifee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_123(strAny); //诊断类-实验室诊断费
		doubleAny = ciMrFpMsgDto.ciMrPat.getDi_idifee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_124(strAny); //诊断类-影像学诊断费
		doubleAny = ciMrFpMsgDto.ciMrPat.getDi_cdifee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_122(strAny); //诊断类-临床诊断项目费
		doubleAny = ciMrFpMsgDto.ciMrPat.getTc_nstpfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_129(strAny); //治疗类-非手术治疗项目费
		doubleAny = ciMrFpMsgDto.ciMrPat.getTc_cptfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_130(strAny); //治疗类-非手术治疗项目费-临床物理治疗费
		doubleAny = ciMrFpMsgDto.ciMrPat.getTc_stfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_131(strAny); //治疗类-手术治疗费
		doubleAny = ciMrFpMsgDto.ciMrPat.getTc_anfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_132(strAny); //治疗类-手术治疗费-麻醉费
		doubleAny = ciMrFpMsgDto.ciMrPat.getTc_opfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_133(strAny); //治疗类-手术治疗费-手术费
		doubleAny = ciMrFpMsgDto.ciMrPat.getRc_rcfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_055(strAny); //康复类-康复费

		//row 130
		doubleAny = ciMrFpMsgDto.ciMrPat.getTcm_cmtfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_136(strAny); //中医类-中医治疗费
		doubleAny = ciMrFpMsgDto.ciMrPat.getWm_wmfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_098(strAny); //西药类-西药费
		doubleAny = ciMrFpMsgDto.ciMrPat.getWm_agfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_099(strAny); //西药类-西药费-抗菌药物费用
		doubleAny = ciMrFpMsgDto.ciMrPat.getTcmt_cpmfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_135(strAny); //中药类-中成药费
		doubleAny = ciMrFpMsgDto.ciMrPat.getTcmt_chmfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_134(strAny); //中药类-中草药费
		doubleAny = ciMrFpMsgDto.ciMrPat.getBabp_bfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_115(strAny); //血液和血液制品类-血费
		doubleAny = ciMrFpMsgDto.ciMrPat.getBabp_apfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_111(strAny); //血液和血液制品类-白蛋白类制品费
		doubleAny = ciMrFpMsgDto.ciMrPat.getBabp_gpfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_113(strAny); //血液和血液制品类-球蛋白类制品费
		doubleAny = ciMrFpMsgDto.ciMrPat.getBabp_bcffee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_112(strAny); //血液和血液制品类-凝血因子类制品费
		doubleAny = ciMrFpMsgDto.ciMrPat.getBabp_cflfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_114(strAny); //血液和血液制品类-细胞因子类制品费

		//row 140
		doubleAny = ciMrFpMsgDto.ciMrPat.getSc_dmmfifee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_038(strAny); //耗材类-检查用一次性医用材料费
		doubleAny = ciMrFpMsgDto.ciMrPat.getSc_dmmftfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_040(strAny); //耗材类-治疗用一次性医用材料费
		doubleAny = ciMrFpMsgDto.ciMrPat.getSc_dmmfsfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_039(strAny); //耗材类-手术用一次性医用材料费
		doubleAny = ciMrFpMsgDto.ciMrPat.getOc_ocfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_11_081(strAny); //其他类-其他费
		
		//dischargeDiagnosisDTO.setZyh(ciMrFpMsgDto.ciMrPat.getNo_inhos()); //住院号)
		strAny  = ""; 
		for (CiMrFpXYDIDTO diag: ciMrFpMsgDto.di_xy){
			//判断是否“出院主诊断”
			if (diag.getFg_maindi().equals(FBoolean.TRUE)){
				strAny = strAny + "|HDSD00_11_024=" + diag.getName_di();
				strAny = strAny + "|HDSD00_11_023=" + diag.getName_di_type();
				strAny = strAny + "|HDSD00_11_025=" + diag.getName_dislvl_inp() + "&";
			} else {
				strAny = strAny + "|HDSD00_11_021=" + diag.getName_di();
				strAny = strAny + "|HDSD00_11_020=" + diag.getName_di_type();
				strAny = strAny + "|HDSD00_11_022=" + diag.getName_dislvl_inp() + "&";
			}
		}
		medicalDto.setHdsd00_11_x01(strAny); //出院诊断信息, 格式见备注[1], varchar2(4000)
		strAny = "";
		for (CiMrFpSugDTO op : ciMrFpMsgDto.sug){
			strAny = strAny + "|HDSD00_11_089=" + op.getSd_sug();
			datetimeAny = op.getDt_start_sug();
			strAny = datetimeAny == null ? "" : datetimeAny.toString();
			strAny = strAny + "|HDSD00_11_091=" + strAny;
			strAny = strAny + "|HDSD00_11_092=" + op.getSd_lvlsug();
			strAny = strAny + "|HDSD00_11_090=" + op.getName_sug();
			strAny = strAny + "|HDSD00_11_094=" + op.getName_emp_sug();
			strAny = strAny + "|HDSD00_11_001=" + op.getName_emp_asst1();
			strAny = strAny + "|HDSD00_11_002=" + op.getName_emp_asst2();
			strAny = strAny + "|HDSD00_11_093=" + op.getSd_incitp();
			strAny = strAny + "|HDSD00_11_082=" + op.getSd_incicondi();
			strAny = strAny + "|HDSD00_11_073=" + op.getSd_anestp();
			strAny = strAny + "|HDSD00_11_074=" + op.getName_emp_anes() + "&";
		}
		medicalDto.setHdsd00_11_x02(strAny); //手术及操作信息，格式见备注[2], varchar2(4000)
		
		return medicalDto;
	}

}
