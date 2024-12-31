package iih.bl.st.ip.s.bp;

import iih.ci.mrfp.cimrfpdto.d.CiMrFpSugDTO;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpZYDiDTO;
import iih.ci.mrfp.cmis.d.CiMrFpMsgDTO;
import iih.mi.biz.dto.d.MedicaluploadTcmDTO;
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
public class XUrbanMedicalTcmDataProcess extends AbstractMedicalDataProcess {

	@SuppressWarnings("unchecked")
	@Override
	public MedicaluploadTcmDTO process(CiMrFpMsgDTO ciMrFpMsgDto) {
		MedicaluploadTcmDTO medicalDto=new MedicaluploadTcmDTO();  						//首页
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
		medicalDto.setHdsd00_12_133(ciMrFpMsgDto.ciMrPat.getName_org()); //医疗机构名称
		medicalDto.setHdsd00_12_134(ciMrFpMsgDto.ciMrPat.getId_org()); //医疗结构组织机构代码
		medicalDto.setHdsd00_12_132(ciMrFpMsgDto.ciMrPat.getSd_pay_method()); //医疗付费方式代码(参照CV07.10.005)
		medicalDto.setHdsd00_12_060(ciMrFpMsgDto.ciMrPat.getHealth_card_id()); //居民健康卡号
		intAny = ciMrFpMsgDto.ciMrPat.getN_times_inhospital();
		strAny = intAny == null ? "0" : intAny.toString();
		medicalDto.setHdsd00_12_166(intAny); //住院次数
		strAny = ciMrFpMsgDto.ciMrPat.getNo_inhos();
		medicalDto.setHdsd00_12_167(strAny); //HIS系统住院号
		medicalDto.setHdsd00_12_007(ciMrFpMsgDto.ciMrPat.getCode_amr_ip()); //病案号
		medicalDto.setHdsd00_12_125(ciMrFpMsgDto.ciMrPat.getName_pat()); //姓名
		medicalDto.setHdsd00_12_124(ciMrFpMsgDto.ciMrPat.getSd_sex()); //性别代码
		
		//row 20
		dateAny = ciMrFpMsgDto.ciMrPat.getDt_birth_pat();
		strAny = dateAny == null ? null : dateAny.getDate().toString();
		medicalDto.setHdsd00_12_015(strAny); //出生日期(YYYY-MM-DD)
		strAny = ciMrFpMsgDto.ciMrPat.getAge();
		strAny = strAny == null ? "0" : strAny.replace("岁", "");
		medicalDto.setHdsd00_12_090(Integer.parseInt(strAny)); //年龄(岁)
		medicalDto.setHdsd00_12_091(ciMrFpMsgDto.ciMrPat.getAge_month()); //年龄(月)
		strAny = ciMrFpMsgDto.ciMrPat.getSd_country();
		strAny = strAny == null ? "00" : strAny;
		medicalDto.setHdsd00_12_043(strAny); //国籍代码(参照E105-01)
		intAny = ciMrFpMsgDto.ciMrPat.getBirth_weight();
		medicalDto.setHdsd00_12_122(intAny); //新生儿出生体重(g)
		intAny = ciMrFpMsgDto.ciMrPat.getAddmission_weight();
		medicalDto.setHdsd00_12_123(intAny); //新生儿入院体重(g)
		addr = addrAnly.getDetailAdderss(ciMrFpMsgDto.ciMrPat.getAddr_born());
		medicalDto.setHdsd00_12_012(addr.getState()); //出生地-省(自治区、直辖市)
		medicalDto.setHdsd00_12_013(addr.getCity()); //出生地-市(地区、州)
		medicalDto.setHdsd00_12_014(addr.getCounty()); //出生地-县(区)
		addr = addrAnly.getDetailAdderss(ciMrFpMsgDto.ciMrPat.getAddr_origin());
		medicalDto.setHdsd00_12_058(addr.getState()); //籍贯-省(自治区、直辖市)

		//row 30
		medicalDto.setHdsd00_12_059(addr.getCity()); //籍贯-市(地区、州)
		medicalDto.setHdsd00_12_088(ciMrFpMsgDto.ciMrPat.getSd_nation()); //民族
		medicalDto.setHdsd00_12_056(ciMrFpMsgDto.ciMrPat.getSd_idtp()); //身份证件类别代码
		medicalDto.setHdsd00_12_055(ciMrFpMsgDto.ciMrPat.getId_code()); //患者身份证件号码
		medicalDto.setHdsd00_12_140(ciMrFpMsgDto.ciMrPat.getSd_occu()); //职业类别代码
		medicalDto.setHdsd00_12_057(ciMrFpMsgDto.ciMrPat.getSd_marry()); //婚姻状况代码
		
		addr = addrAnly.getDetailAdderss(ciMrFpMsgDto.ciMrPat.getAddr_now());
		medicalDto.setHdsd00_12_117(addr.getState()); //现住址-省(自治区、直辖市)
		medicalDto.setHdsd00_12_118(addr.getCity()); //现住址-市(地区、州)
		medicalDto.setHdsd00_12_119(addr.getCounty()); //现住址-县(区)
		medicalDto.setHdsd00_12_120(addr.getTownship()); //现住址-乡(镇、街道办事处)

		//row 40
		medicalDto.setHdsd00_12_115(addr.getStreetName()); //现住址-村(街、路、弄等)
		medicalDto.setHdsd00_12_116(addr.getHoseNumber()); //现住址-门牌号码
		medicalDto.setHdsd00_12_033(ciMrFpMsgDto.ciMrPat.getTel_addr_now()); //电话号码
		medicalDto.setHdsd00_12_121(ciMrFpMsgDto.ciMrPat.getZip_addr_now()); //现住址-邮政编码
		
		addr = addrAnly.getDetailAdderss(ciMrFpMsgDto.ciMrPat.getAddr_now());
		medicalDto.setHdsd00_12_050(addr.getState()); //户口地址-省(自治区、直辖市)
		medicalDto.setHdsd00_12_051(addr.getCity()); //户口地址-市(地区、州)
		medicalDto.setHdsd00_12_052(addr.getCounty()); //户口地址-县(区)
		medicalDto.setHdsd00_12_053(addr.getTownship()); //户口地址-乡(镇、街道办事处)
		medicalDto.setHdsd00_12_048(addr.getStreetName()); //户口地址-村(街、路、弄等)
		medicalDto.setHdsd00_12_049(addr.getHoseNumber()); //户口地址-门牌号码

		//row 50
		medicalDto.setHdsd00_12_054(ciMrFpMsgDto.ciMrPat.getZip_addr_cencus()); //户口地址-邮政编码
		medicalDto.setHdsd00_12_042(ciMrFpMsgDto.ciMrPat.getWorkunit()); //工作单位名称
		addr = addrAnly.getDetailAdderss(ciMrFpMsgDto.ciMrPat.getAddr_work());
		medicalDto.setHdsd00_12_036(addr.getState()); //工作单位地址-省(自治区、直辖市)
		medicalDto.setHdsd00_12_037(addr.getCity()); //工作单位地址-市(地区、州)
		medicalDto.setHdsd00_12_038(addr.getCounty()); //工作单位地址-县(区)
		medicalDto.setHdsd00_12_039(addr.getStreetName()); //工作单位地址-乡(镇、街道办事处)
		medicalDto.setHdsd00_12_034(addr.getTownship()); //工作单位地址-村(街、路、弄等)
		medicalDto.setHdsd00_12_035(addr.getHoseNumber()); //工作单位地址-门牌号码
		medicalDto.setHdsd00_12_041(ciMrFpMsgDto.ciMrPat.getDel_addr_work()); //工作单位电话号码
		medicalDto.setHdsd00_12_040(ciMrFpMsgDto.ciMrPat.getZip_addr_work()); //工作单位地址-邮政编码

		//row 60
		medicalDto.setHdsd00_12_072(ciMrFpMsgDto.ciMrPat.getName_cont()); //联系人姓名
		medicalDto.setHdsd00_12_073(ciMrFpMsgDto.ciMrPat.getSd_conttp()); //联系人与患者的关系代码
		addr = addrAnly.getDetailAdderss(ciMrFpMsgDto.ciMrPat.getAddr_cont());
		medicalDto.setHdsd00_12_067(addr.getState()); //联系人地址-省(自治区、直辖市)
		medicalDto.setHdsd00_12_068(addr.getCity()); //联系人地址-市(地区、州)
		medicalDto.setHdsd00_12_069(addr.getCounty()); //联系人地址-县(区)
		medicalDto.setHdsd00_12_070(addr.getTownship()); //联系人地址-乡(镇、街道办事处)
		medicalDto.setHdsd00_12_065(addr.getStreetName()); //联系人地址-村(街、路、弄等)
		medicalDto.setHdsd00_12_066(addr.getHoseNumber()); //联系人地址-门牌号码
		medicalDto.setHdsd00_12_071(ciMrFpMsgDto.ciMrPat.getTel_cont()); //联系人电话号码
		medicalDto.setHdsd00_12_097(ciMrFpMsgDto.ciMrPat.getSd_referalsrc()); //入院途径代码(参照CV09.00.403)

		//row 70
		datetimeAny = ciMrFpMsgDto.ciMrPat.getDt_end();
		strAny = datetimeAny == null ? null : datetimeAny.toString();
		medicalDto.setHdsd00_12_144(ciMrFpMsgDto.ciMrPat.getDt_acpt().toStdString()); //治疗类别代码(参照CV06.00.225)
		medicalDto.setHdsd00_12_096(ciMrFpMsgDto.ciMrPat.getDt_acpt().toStdString()); //入院日期时间(YYYY-MM-DD)
		medicalDto.setHdsd00_12_095(ciMrFpMsgDto.ciMrPat.getName_dep_phyadm()); //入院科别（传输名称）
		medicalDto.setHdsd00_12_094(ciMrFpMsgDto.ciMrPat.getName_in_bed()); //入院病房（传输名称）
		medicalDto.setHdsd00_12_171(ciMrFpMsgDto.ciMrPat.getName_dep_trans()); //转科科别（传输名称）
		medicalDto.setHdsd00_12_020(strAny); //出院日期时间(YYYY-MM-DD)
		medicalDto.setHdsd00_12_019(ciMrFpMsgDto.ciMrPat.getName_dep_phydisc()); //出院科别（传输名称）
		medicalDto.setHdsd00_12_018(ciMrFpMsgDto.ciMrPat.getName_out_bed()); //出院病房（传输名称）

		intAny = ciMrFpMsgDto.ciMrPat.getHosdays();
		strAny = intAny == null ? "0" : intAny.toString();
		medicalDto.setHdsd00_12_098(Integer.parseInt(strAny)); //实际住院天数
		medicalDto.setHdsd00_12_085(ciMrFpMsgDto.ciMrPat.getName_outp_emer_di()); //门(急)诊诊断(中医诊断)名称
		medicalDto.setHdsd00_12_084(ciMrFpMsgDto.ciMrPat.getSd_outp_emer_di()); //门(急)诊诊断(中医诊断)病名编码(参照GB/T 15657-1995)
		medicalDto.setHdsd00_12_086(ciMrFpMsgDto.ciMrPat.getName_outp_emer_di()); //门(急)诊诊断(中医诊断)名称
		medicalDto.setHdsd00_12_087(ciMrFpMsgDto.ciMrPat.getSd_outp_emer_di()); //门(急)诊诊断(中医诊断)证候编码(参照GB/T 15657-1995)
		medicalDto.setHdsd00_12_083(ciMrFpMsgDto.ciMrPat.getName_outp_emer_di()); //门(急)诊诊断(西医诊断)名称
		medicalDto.setHdsd00_12_082(ciMrFpMsgDto.ciMrPat.getSd_outp_emer_di()); //门(急)诊诊断(西医诊断)疾病编码（参照ICD-10）
		medicalDto.setHdsd00_12_099(ciMrFpMsgDto.ciMrPat.getId_cipathtype()); //实施临床路径标志代码（1.中医 2.西医 3.否）
		medicalDto.setHdsd00_12_101(ciMrFpMsgDto.ciMrPat.getId_usecmp()); //使用医疗机构中药制剂标志
		medicalDto.setHdsd00_12_103(ciMrFpMsgDto.ciMrPat.getId_usecme()); //使用中医诊疗设备标志
		medicalDto.setHdsd00_12_102(ciMrFpMsgDto.ciMrPat.getId_usecmdt()); //使用中医诊疗技术标志
		medicalDto.setHdsd00_12_006(ciMrFpMsgDto.ciMrPat.getId_dnur()); //辨证施护标志

		
		//row 80
		//诊断
		medicalDto.setHdsd00_12_x01(ciMrFpMsgDto.ciMrPat.getNo_inhos()); //出院诊断信息, 格式见备注[1], varchar2(4000)
		medicalDto.setHdsd00_12_111(ciMrFpMsgDto.ciMrPat.getName_iioutreason()); //损伤中毒的外部原因
		medicalDto.setHdsd00_12_112(ciMrFpMsgDto.ciMrPat.getSd_iioutreason()); //损伤中毒的外部原因疾病编码(参照ICD-10)
		medicalDto.setHdsd00_12_011(ciMrFpMsgDto.ciMrPat.getName_dipathology()); //病理诊断名称
		medicalDto.setHdsd00_12_010(ciMrFpMsgDto.ciMrPat.getSd_dipathology()); //病理诊断疾病编码(参照ICD-10)
		medicalDto.setHdsd00_12_009(ciMrFpMsgDto.ciMrPat.getNum_patho()); //病理号
		strAny = ciMrFpMsgDto.ciMrPat.getId_drug_allergy();
		strAny = strAny == null ? "0" : strAny;
		medicalDto.setHdsd00_12_131(strAny); //药物过敏标志(1.是 2.否)
		medicalDto.setHdsd00_12_044(ciMrFpMsgDto.ciMrPat.getAllergic_drugs()); //过敏药物
		strAny = ciMrFpMsgDto.ciMrPat.getId_aut_dead_pat();
		strAny = strAny == null ? "0" : strAny;
		medicalDto.setHdsd00_12_110(strAny); //死亡患者尸检标志(1.是 2.否)
		medicalDto.setHdsd00_12_003(ciMrFpMsgDto.ciMrPat.getId_blood_type()); //ABO血型代码
		
		//row 90
		medicalDto.setHdsd00_12_004(ciMrFpMsgDto.ciMrPat.getId_rh_type()); //Rh血型代码(参照CV04.50.020)
		medicalDto.setHdsd00_12_063(ciMrFpMsgDto.ciMrPat.getDirofdept()); //科主任签名
		medicalDto.setHdsd00_12_164(ciMrFpMsgDto.ciMrPat.getName_zr_doc()); //主任(副主任)医师签名
		medicalDto.setHdsd00_12_165(ciMrFpMsgDto.ciMrPat.getName_zz_doc()); //主治医师签名
		medicalDto.setHdsd00_12_168(ciMrFpMsgDto.ciMrPat.getSd_zy_doc()); //住院医师签名
		medicalDto.setHdsd00_12_135(ciMrFpMsgDto.ciMrPat.getName_emp_nur()); //责任护士签名
		medicalDto.setHdsd00_12_061(ciMrFpMsgDto.ciMrPat.getName_learn_doc()); //进修医师签名
		medicalDto.setHdsd00_12_100(ciMrFpMsgDto.ciMrPat.getName_intern_doc()); //实习医师签名
		medicalDto.setHdsd00_12_005(ciMrFpMsgDto.ciMrPat.getName_coder()); //编码员签名
		medicalDto.setHdsd00_12_008(ciMrFpMsgDto.ciMrPat.getId_qom_record()); //病案质量代码(1.甲 2.乙 3.丙)
		
		//row 100
		//手术
		FDate dateAny2;
		dateAny2 = ciMrFpMsgDto.ciMrPat.getQc_date();
		strAny = dateAny == null ? null : dateAny2.toString();
		medicalDto.setHdsd00_12_143(ciMrFpMsgDto.ciMrPat.getName_qcp_doc()); //质控医师签名
		medicalDto.setHdsd00_12_141(ciMrFpMsgDto.ciMrPat.getName_qcp_nur()); //质控护士签名
		medicalDto.setHdsd00_12_142(strAny); //质控日期(YYYY-MM-DD)
		medicalDto.setHdsd00_12_x02(ciMrFpMsgDto.ciMrPat.getNo_inhos()); //手术及操作信息，格式见备注[2], varchar2(4000)
		medicalDto.setHdsd00_12_064(ciMrFpMsgDto.ciMrPat.getOut_hos_mode()); //离院方式代码(参照CV06.00.226)
		medicalDto.setHdsd00_12_089(ciMrFpMsgDto.ciMrPat.getName_med_in_1()); //拟接收医疗机构名称
		strAny = ciMrFpMsgDto.ciMrPat.getId_is_have_inhos_plan();
		strAny = strAny == null ? "0" : strAny;
		medicalDto.setHdsd00_12_016(strAny); //出院31天内再住院标志(1.是 2.否)
		medicalDto.setHdsd00_12_017(ciMrFpMsgDto.ciMrPat.getName_is_have_inhos_plan()); //出院31天内再住院目的
		
		intAny = ciMrFpMsgDto.ciMrPat.getComa_time_bef_inhos_days();
		medicalDto.setHdsd00_12_077(intAny); //颅脑损伤患者入院前昏迷时间-d
		intAny = ciMrFpMsgDto.ciMrPat.getComa_time_bef_inhos_hours();
		medicalDto.setHdsd00_12_078(intAny); //颅脑损伤患者入院前昏迷时间-h

		//row 110
		intAny = ciMrFpMsgDto.ciMrPat.getComa_time_bef_inhos_mins();
		medicalDto.setHdsd00_12_079(intAny); //颅脑损伤患者入院前昏迷时间-min
		intAny = ciMrFpMsgDto.ciMrPat.getComa_time_inhos_days();
		medicalDto.setHdsd00_12_074(intAny); //颅脑损伤患者入院后昏迷时间-d
		intAny = ciMrFpMsgDto.ciMrPat.getComa_time_inhos_hours();
		medicalDto.setHdsd00_12_075(intAny); //颅脑损伤患者入院后昏迷时间-h
		intAny = ciMrFpMsgDto.ciMrPat.getComa_time_inhos_mins();
		medicalDto.setHdsd00_12_076(intAny); //颅脑损伤患者入院后昏迷时间-min
		doubleAny = ciMrFpMsgDto.ciMrPat.getAmount();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_169(strAny); //住院总费用
		doubleAny = ciMrFpMsgDto.ciMrPat.getCms_spamount();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_170(strAny); //住院总费用-自付金额
		doubleAny = ciMrFpMsgDto.ciMrPat.getCms_gmsfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_174(strAny); //综合医疗服务类-一般医疗服务费
		medicalDto.setHdsd00_12_175(strAny); //综合医疗服务类-一般医疗服务费-中医辨证论治费
		medicalDto.setHdsd00_12_176(strAny); //综合医疗服务类-一般医疗服务费-中医辨证论治会诊费
		doubleAny = ciMrFpMsgDto.ciMrPat.getCms_gtofee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_177(strAny); //综合医疗服务类-一般治疗操作费
		doubleAny = ciMrFpMsgDto.ciMrPat.getCms_nurfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_172(strAny); //综合医疗服务类-护理费
		doubleAny = ciMrFpMsgDto.ciMrPat.getCms_otherfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_173(strAny); //综合医疗服务类-其他费用

		//row 120
		doubleAny = ciMrFpMsgDto.ciMrPat.getDi_pdifee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_136(strAny); //诊断类-病理诊断费
		doubleAny = ciMrFpMsgDto.ciMrPat.getDi_ldifee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_138(strAny); //诊断类-实验室诊断费
		doubleAny = ciMrFpMsgDto.ciMrPat.getDi_idifee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_139(strAny); //诊断类-影像学诊断费
		doubleAny = ciMrFpMsgDto.ciMrPat.getDi_cdifee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_137(strAny); //诊断类-临床诊断项目费
		doubleAny = ciMrFpMsgDto.ciMrPat.getTc_nstpfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_145(strAny); //治疗类-非手术治疗项目费
		doubleAny = ciMrFpMsgDto.ciMrPat.getTc_cptfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_146(strAny); //治疗类-非手术治疗项目费-临床物理治疗费
		doubleAny = ciMrFpMsgDto.ciMrPat.getTc_stfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_147(strAny); //治疗类-手术治疗费
		doubleAny = ciMrFpMsgDto.ciMrPat.getTc_anfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_148(strAny); //治疗类-手术治疗费-麻醉费
		doubleAny = ciMrFpMsgDto.ciMrPat.getTc_opfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_149(strAny); //治疗类-手术治疗费-手术费
		doubleAny = ciMrFpMsgDto.ciMrPat.getRc_rcfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_062(strAny); //康复类-康复费

		//row 130
		doubleAny = ciMrFpMsgDto.ciMrPat.getTcm_cmtfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_156(strAny); //中医类-中医诊断费
		medicalDto.setHdsd00_12_157(strAny); //中医类-中医治疗费
		medicalDto.setHdsd00_12_163(strAny); //中医类-中医治疗费-中医外治费
		medicalDto.setHdsd00_12_160(strAny); //中医类-中医治疗费-中医骨伤费
		medicalDto.setHdsd00_12_158(strAny); //中医类-中医治疗费-针刺与灸法费
		medicalDto.setHdsd00_12_162(strAny); //中医类-中医治疗费-中医推拿治疗费
		medicalDto.setHdsd00_12_159(strAny); //中医类-中医治疗费-中医肛肠治疗费
		medicalDto.setHdsd00_12_161(strAny); //中医类-中医治疗费-中医特殊治疗费
		medicalDto.setHdsd00_12_153(strAny); //中医类-中医其他费
		medicalDto.setHdsd00_12_155(strAny); //中医类-中医其他费-中医特殊调配加工费
		medicalDto.setHdsd00_12_154(strAny); //中医类-中医其他费-辨证施膳费
		doubleAny = ciMrFpMsgDto.ciMrPat.getWm_wmfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_113(strAny); //西药类-西药费
		doubleAny = ciMrFpMsgDto.ciMrPat.getWm_agfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_114(strAny); //西药类-西药费-抗菌药物费用
		doubleAny = ciMrFpMsgDto.ciMrPat.getTcmt_cpmfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_151(strAny); //中药类-中成药费
		medicalDto.setHdsd00_12_152(strAny); //中药类-中成药费-医疗机构中药制剂费
		doubleAny = ciMrFpMsgDto.ciMrPat.getTcmt_chmfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_150(strAny); //中药类-中草药费
		doubleAny = ciMrFpMsgDto.ciMrPat.getBabp_bfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_130(strAny); //血液和血液制品类-血费
		doubleAny = ciMrFpMsgDto.ciMrPat.getBabp_apfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_126(strAny); //血液和血液制品类-白蛋白类制品费
		doubleAny = ciMrFpMsgDto.ciMrPat.getBabp_gpfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_128(strAny); //血液和血液制品类-球蛋白类制品费
		doubleAny = ciMrFpMsgDto.ciMrPat.getBabp_bcffee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_127(strAny); //血液和血液制品类-凝血因子类制品费
		doubleAny = ciMrFpMsgDto.ciMrPat.getBabp_cflfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_129(strAny); //血液和血液制品类-细胞因子类制品费

		//row 140
		doubleAny = ciMrFpMsgDto.ciMrPat.getSc_dmmfifee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_045(strAny); //耗材类-检查用一次性医用材料费
		doubleAny = ciMrFpMsgDto.ciMrPat.getSc_dmmftfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_047(strAny); //耗材类-治疗用一次性医用材料费
		doubleAny = ciMrFpMsgDto.ciMrPat.getSc_dmmfsfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_046(strAny); //耗材类-手术用一次性医用材料费
		doubleAny = ciMrFpMsgDto.ciMrPat.getOc_ocfee();
		strAny = doubleAny == null ? null : doubleAny.toString();
		medicalDto.setHdsd00_12_092(strAny); //其他类-其他费
		
		//dischargeDiagnosisDTO.setZyh(ciMrFpMsgDto.ciMrPat.getNo_inhos()); //住院号)
		strAny  = ""; 
		for (CiMrFpZYDiDTO diag: ciMrFpMsgDto.di_zy){
			//判断是否“出院主诊断”
			if (diag.getFg_maindi().equals(FBoolean.TRUE)){
				strAny = strAny + "|HDSD00_12_028=" + diag.getName_di();
				strAny = strAny + "|HDSD00_11_027=" + diag.getName_di_type();
				strAny = strAny + "|HDSD00_11_029=" + diag.getName_dislvl_inp();
				strAny = strAny + "|HDSD00_12_030=" + diag.getId_syndrome();
				strAny = strAny + "|HDSD00_11_032=" + diag.getSd_syndrome();
				strAny = strAny + "|HDSD00_11_031=" + diag.getName_syndrome() + "&";
			} else {
				strAny = strAny + "|HDSD00_11_025=" + diag.getName_di();
				strAny = strAny + "|HDSD00_11_024=" + diag.getName_di_type();
				strAny = strAny + "|HDSD00_11_026=" + diag.getName_dislvl_inp() + "&";
			}
		}
		medicalDto.setHdsd00_12_x01(strAny); //出院诊断信息, 格式见备注[1], varchar2(4000)
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
		medicalDto.setHdsd00_12_x02(strAny); //手术及操作信息，格式见备注[2], varchar2(4000)
		
		return medicalDto;
	}

}
