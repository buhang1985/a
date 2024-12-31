package iih.ci.mrfp.mrfpxml.s;


import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.vo.pub.formulaset.function.DateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpDTO;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpSugDTO;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpXYDIDTO;
import iih.ci.mrfp.cimrfpdto.d.CimrfpdtoAggDTO;
import iih.ci.mrfp.cimrfpdto.i.ICiMrFpDTOEntRService;
import iih.ci.mrfp.cmis.d.CiMrFpMsgDTO;
import iih.ci.mrfp.cmis.i.ICMISService;
import iih.ci.mrfp.cmis.s.CMISServiceImpl;
import iih.ci.mrfp.di2mrfp.d.CiMrfpDiDO;
import iih.ci.mrfp.mrfpxml.d.ActAlg;
import iih.ci.mrfp.mrfpxml.d.Address;
import iih.ci.mrfp.mrfpxml.d.AsOrganizationPartOf;
import iih.ci.mrfp.mrfpxml.d.AssignedAuthor;
import iih.ci.mrfp.mrfpxml.d.AssignedAuthorChDep;
import iih.ci.mrfp.mrfpxml.d.AssignedCustodian;
import iih.ci.mrfp.mrfpxml.d.AssociatedEntity;
import iih.ci.mrfp.mrfpxml.d.Author;
import iih.ci.mrfp.mrfpxml.d.AuthorChDep;
import iih.ci.mrfp.mrfpxml.d.CName;
import iih.ci.mrfp.mrfpxml.d.CValue;
import iih.ci.mrfp.mrfpxml.d.ClinicalDocument;
import iih.ci.mrfp.mrfpxml.d.Code;
import iih.ci.mrfp.mrfpxml.d.CodeLife;
import iih.ci.mrfp.mrfpxml.d.ComponentOf;
import iih.ci.mrfp.mrfpxml.d.ComponentSon;
import iih.ci.mrfp.mrfpxml.d.Custodian;
import iih.ci.mrfp.mrfpxml.d.DoctorNur;
import iih.ci.mrfp.mrfpxml.d.DoctorNurEntity;
import iih.ci.mrfp.mrfpxml.d.EffectiveTime;
import iih.ci.mrfp.mrfpxml.d.EmployerOrganization;
import iih.ci.mrfp.mrfpxml.d.EncompassingEncounter;
import iih.ci.mrfp.mrfpxml.d.EntryAlg;
import iih.ci.mrfp.mrfpxml.d.EntryHel;
import iih.ci.mrfp.mrfpxml.d.EntryHel2;
import iih.ci.mrfp.mrfpxml.d.EntryLife;
import iih.ci.mrfp.mrfpxml.d.EntryRelationship;
import iih.ci.mrfp.mrfpxml.d.EntryRelationshipAlg;
import iih.ci.mrfp.mrfpxml.d.EntryRelationshipSug;
import iih.ci.mrfp.mrfpxml.d.EntrySug;
import iih.ci.mrfp.mrfpxml.d.HealthCarFacility;
import iih.ci.mrfp.mrfpxml.d.Identification;
import iih.ci.mrfp.mrfpxml.d.Location;
import iih.ci.mrfp.mrfpxml.d.ObserVationChDep;
import iih.ci.mrfp.mrfpxml.d.Observation;
import iih.ci.mrfp.mrfpxml.d.ObservationAlg;
import iih.ci.mrfp.mrfpxml.d.ObservationHel;
import iih.ci.mrfp.mrfpxml.d.ObservationQu;
import iih.ci.mrfp.mrfpxml.d.ObservationSug;
import iih.ci.mrfp.mrfpxml.d.OrganizaWard;
import iih.ci.mrfp.mrfpxml.d.OrganizerDi;
import iih.ci.mrfp.mrfpxml.d.ParentDocument;
import iih.ci.mrfp.mrfpxml.d.Participant;
import iih.ci.mrfp.mrfpxml.d.ParticipantAlg;
import iih.ci.mrfp.mrfpxml.d.ParticipantRole;
import iih.ci.mrfp.mrfpxml.d.Patient;
import iih.ci.mrfp.mrfpxml.d.PatientRole;
import iih.ci.mrfp.mrfpxml.d.Place;
import iih.ci.mrfp.mrfpxml.d.PlayingEntity;
import iih.ci.mrfp.mrfpxml.d.ProcedureSug;
import iih.ci.mrfp.mrfpxml.d.ProviderOrganization;
import iih.ci.mrfp.mrfpxml.d.Qualifier;
import iih.ci.mrfp.mrfpxml.d.RecordTarget;
import iih.ci.mrfp.mrfpxml.d.RelatedDocument;
import iih.ci.mrfp.mrfpxml.d.SectionAlg;
import iih.ci.mrfp.mrfpxml.d.SectionBL;
import iih.ci.mrfp.mrfpxml.d.SectionCP;
import iih.ci.mrfp.mrfpxml.d.SectionChDep;
import iih.ci.mrfp.mrfpxml.d.SectionDi;
import iih.ci.mrfp.mrfpxml.d.SectionHel;
import iih.ci.mrfp.mrfpxml.d.SectionIHH;
import iih.ci.mrfp.mrfpxml.d.SectionLife;
import iih.ci.mrfp.mrfpxml.d.SectionOutHos;
import iih.ci.mrfp.mrfpxml.d.SectionQu;
import iih.ci.mrfp.mrfpxml.d.SectionSug;
import iih.ci.mrfp.mrfpxml.d.ServiceProviderOrganization;
import iih.ci.mrfp.mrfpxml.d.StructuredBody;
import iih.ci.mrfp.mrfpxml.d.WholeOrganization;
import iih.ci.mrfp.mrfpxml.i.ICiMrmMrfpXMLEntRService;
import iih.ci.mrqc.amrapply.d.AmrApplyDO;
import iih.ci.mrqc.amrapply.i.IAmrapplyRService;
import iih.pi.reg.pat.d.sdpiinvdmd;

/**
 * 处理病案首页医保信息
 * @author 张静波
 *
 */
public class ICiMrmMrfpXMLEntRServiceImpl implements ICiMrmMrfpXMLEntRService {

	/**
	 * 根据就诊号将病案首页信息转成医保xml数据
	 * @param id_ent
	 * @return
	 * @throws BizException 
	 */
	public  String convertData2XMLObj(String id_ent) throws BizException
	{
		ICMISService _service = ServiceFinder.find(ICMISService.class) ;
		CiMrFpMsgDTO cimrfpdto =  _service.getCimrfpdtoAggDTO(id_ent);//获取病案首页信息
		ClinicalDocument clinicalDocument = getClinicalDocument(cimrfpdto);
		//String strXML = convertToXml(clinicalDocument);		
		//System.out.println(strXML);
		//return strXML;
		convertToXml(clinicalDocument,"D:\\test.xml");
		return "";
		
	}
	
	/**
	 * 将对象数据转成xml字符串
	 * @param doc
	 * @return
	 */
	public  String getXML(ClinicalDocument doc)
	{
		return "";
	}
	
	/**
	 * 将病案首页信息转成医保xml对象格式数据
	 * @param cimrfp
	 * @throws BizException 
	 */
	private ClinicalDocument getClinicalDocument(CiMrFpMsgDTO cimrfp) throws BizException
	{
		ClinicalDocument clinicalDocument = new ClinicalDocument();
		
		CiMrFpDTO pat =cimrfp.ciMrPat;
		Code realmCode = new Code();
		realmCode.setCode("CN");
		clinicalDocument.setRealmCode(realmCode);
		Identification typeId = new Identification();
		typeId.setRoot("2.16.840.1.113883.1.3");
		typeId.setExtension("POCD_MT000040");
		clinicalDocument.setTypeId(typeId);
		Identification templateId = new Identification();
		templateId.setRoot("2.16.156.10011.2.1.1.52");
		clinicalDocument.setTemplateId(templateId);
		Identification id= new Identification();
		id.setRoot("2.16.156.10011.1.1");
		id.setExtension("RN001");
		clinicalDocument.setId(id);		
		Code code = new Code();
		code.setCode("C0032");
		code.setCodeSystem("2.16.156.10011.2.4");
		code.setCodeSystemName("卫生信息共享文档编码体系");
		clinicalDocument.setCode(code);		
		clinicalDocument.setTitle("中医住院病案首页");
		
		CValue effectiveTime = new CValue();
		
		SimpleDateFormat  format = new SimpleDateFormat("yyyyMMddHHMMss");
		String time = format.format(new Date());
		effectiveTime.setValue(time);//文档机器生成时间
		clinicalDocument.setEffectiveTime(effectiveTime);
		Code confidentialityCode = new Code();
		confidentialityCode.setCode("N");
		confidentialityCode.setCodeSystem("2.16.840.1.113883.5.25");
		confidentialityCode.setCodeSystemName("Confidentiality");
		confidentialityCode.setDisplayName("正常访问保密级别");
		clinicalDocument.setConfidentialityCode(confidentialityCode);
		Code languageCode=new Code();
		languageCode.setCode("zh-CN");
		clinicalDocument.setLanguageCode(languageCode);	
		clinicalDocument.setSetId("");
		CValue versionNumber = new CValue();
		IAmrapplyRService amrApplyService=ServiceFinder.find(IAmrapplyRService.class);
		AmrApplyDO[] applyArr =amrApplyService.find("a0.id_ent='"+cimrfp.ciMrPat.getId_ent()+"'", "", FBoolean.FALSE);
		if (applyArr.length>0) {
			versionNumber.setValue("1");;//修改   给集成平台发送过消息
		} else {
			versionNumber.setValue("0");;//新增
		}		
		clinicalDocument.setVersionNumber(versionNumber);		
		clinicalDocument.setRecordTarget(getRecordTarget(pat));
		clinicalDocument.setAuthor(getAuthor(pat));
		clinicalDocument.setCustodian(getCustodian(pat));
		clinicalDocument.setLegalAuthenticator(getLegalAuthenticator(pat));
		clinicalDocument.setAuthenticator_zr(getAuthenticator_zr(pat));
		clinicalDocument.setAuthenticator_zz(getAuthenticator_zz(pat));
		clinicalDocument.setAuthenticator_zy(getAuthenticator_zy(pat));
		clinicalDocument.setAuthenticator_zrhs(getAuthenticator_zrhs(pat));
		clinicalDocument.setAuthenticator_jx(getAuthenticator_jx(pat));
		clinicalDocument.setAuthenticator_sx(getAuthenticator_sx(pat));
		clinicalDocument.setAuthenticator_bm(getAuthenticator_bm(pat));
		clinicalDocument.setParticipant(getParticipant(pat));
		clinicalDocument.setRelatedDocument(getRelatedDocument());
		clinicalDocument.setComponentOf(getComponentOf(pat));
		List<StructuredBody> structureBodys = new ArrayList<StructuredBody>();
		structureBodys.add(getStructuredBody(cimrfp));
		clinicalDocument.setStructureBody(structureBodys);
		return clinicalDocument;
	}
	
	/**
	 * 获取文档对象（患者）
	 * @return
	 */
	private RecordTarget getRecordTarget(CiMrFpDTO pat)
	{
		RecordTarget recordTarget = new RecordTarget();
		recordTarget.setTypeCode("RCT");
		recordTarget.setContextControlCode("OP");
		
		PatientRole pr = new PatientRole();
		pr.setClassCode("PAT");
		
		Identification idHealth = new Identification();
		idHealth.setRoot("2.16.156.10011.1.19");
		idHealth.setExtension(pat.getHealth_card_id());//健康卡号
		pr.setIdHealth(idHealth);
		Identification idInHospital = new Identification();
		idInHospital.setRoot("2.16.156.10011.1.12");
		idInHospital.setExtension(pat.getNo_inhos());//住院号
		pr.setIdInHospital(idInHospital);
		Identification idPatient = new Identification();
		idPatient.setRoot("2.16.156.10011.1.13");
		idPatient.setExtension(pat.getCode_amr_ip());//病案号
		pr.setIdPatient(idPatient);
		Address addr = getDetailAdderss(pat.getAddr_now());
		addr.setUse("H");
		addr.setPostalCode(pat.getZip_addr_now());
		pr.setAddr(addr);
		CValue telecom = new CValue();
		telecom.setValue(pat.getTel_addr_now());
		pr.setTelecom(telecom);
		Patient patient = new Patient();
		patient.setClassCode("PSN");
		patient.setDeterminerCode("INSTANCE");
		Identification id = new Identification();
		id.setRoot("2.16.156.10011.1.3");
		id.setExtension(pat.getId_code());//身份证号
		patient.setId(id);
		patient.setName(pat.getName_pat());
		Code administrativeGenderCode = new Code();//性别
		administrativeGenderCode.setCode(pat.getSd_sex());
		administrativeGenderCode.setCodeSystem("2.16.156.10011.2.3.3.4");		
		administrativeGenderCode.setDisplayName(pat.getName_sex());
		administrativeGenderCode.setCodeSystemName("生理性别代码表（GB/T 2261.1）");
		patient.setAdministrativeGenderCode(administrativeGenderCode);
		CValue birthTime = new CValue();
		if(pat.getDt_birth_pat()==null)//出生日期
			birthTime.setValue(null);
		else
			birthTime.setValue(pat.getDt_birth_pat().toLocalString());
		patient.setBirthTime(birthTime);
		Code maritalStatusCode = new Code();//婚姻代码
		maritalStatusCode.setCode(pat.getSd_marry());
		maritalStatusCode.setDisplayName(pat.getName_marry());
		maritalStatusCode.setCodeSystem("2.16.156.10011.2.3.3.5");
		maritalStatusCode.setCodeSystemName("婚姻状况代码表（GB/T 2261.2）");
		patient.setMaritalStatusCode(maritalStatusCode);
		Code ethnicGroupCode = new Code();//民族
		if(pat.getSd_nation()!=null)
		{
			int sd_na = Integer.parseInt(pat.getSd_nation());
			ethnicGroupCode.setCode(Integer.toString(sd_na));
		}
		else
			ethnicGroupCode.setCode("");
		ethnicGroupCode.setDisplayName(pat.getName_nation());
		ethnicGroupCode.setCodeSystem("2.16.156.10011.2.3.3.3");
		ethnicGroupCode.setCodeSystemName("民族类别代码表（GB 3304）");
		patient.setEthnicGroupCode(ethnicGroupCode);		
		List<Place> birthplace =new  ArrayList<Place>();//出生地址
		Place pBirth=new Place();
		pBirth.setClassCode("PLC");
		pBirth.setDeterminerCode("INSTANCE");
		Address addBirth = this.getDetailAdderss(pat.getAddr_born());
		addBirth.setPostalCode("");//界面无邮编
		pBirth.setAddr(addBirth);	
		birthplace.add(pBirth);
		patient.setBirthplace(birthplace);
		Code nationality = new Code();//国籍
		nationality.setCode(pat.getSd_country());
		nationality.setCodeSystem("2.16.156.10011.2.3.3.1");
		nationality.setCodeSystemName("世界各国和地区名称代码(GB/T 2659)");
		nationality.setDisplayName(pat.getName_country());
		patient.setNationality(nationality);
		CValue age = new CValue();//年龄
		if(pat.getAge()==null||pat.getAge().length()==0)
		{
			age.setUnit("月");
			age.setValue(pat.getAge_month());
		}
		else
		{
			age.setUnit("年");
			age.setValue(pat.getAge());
		}
		
		patient.setAge(age);
		EmployerOrganization employerOrganization = new EmployerOrganization();//工作单位
		employerOrganization.setName(pat.getWorkunit());
		CValue telecomWork = new CValue();
		telecomWork.setValue(pat.getDel_addr_work());
		employerOrganization.setTelecom(telecomWork);
		Address addWork = this.getDetailAdderss(pat.getWorkunit());
		addWork.setPostalCode(pat.getZip_addr_work());
		employerOrganization.setAddr(addWork);
		patient.setEmployerOrganization(employerOrganization);
		List<Place> household = new ArrayList<Place>();//户口信息
		Place pHouse = new Place();
		pHouse.setClassCode("PLC");
		pHouse.setDeterminerCode("INSTANCE");
		Address addrHouse = this.getDetailAdderss(pat.getAddr_cencus());
		addrHouse.setPostalCode(pat.getZip_addr_cencus());
		pHouse.setAddr(addrHouse);
		household.add(pHouse);
		patient.setHousehold(household);
		List<Place> nativePlace = new ArrayList<Place>();//籍贯
		Place pNative = new Place();
		pNative.setClassCode("PLC");
		pNative.setDeterminerCode("INSTANCE");
		Address addrNative = this.getDetailAdderss(pat.getAddr_origin());
		pNative.setAddr(addrNative);
		nativePlace.add(pNative);
		patient.setHousehold(nativePlace);
		patient.setNativePlace(nativePlace);
		List<Code> occupations = new ArrayList<Code>();//职业状况
		Code occupation = new Code();
		occupation.setCode(pat.getSd_occu());
		occupation.setCodeSystem("2.16.156.10011.2.3.3.13");
		occupation.setCodeSystemName("从业状况（个人身体）代码表（GB/T 2261.4）");
		occupation.setDisplayName(pat.getName_occu());
		occupations.add(occupation);
		patient.setOccupations(occupations);
		pr.setPatient(patient);
		ProviderOrganization providerOrganization = new ProviderOrganization();
		providerOrganization.setClassCode("ORG");
		providerOrganization.setDeterminerCode("INSTANCE");
		Identification idProvider = new Identification();
		idProvider.setRoot("2.16.156.10011.1.5");
		idProvider.setExtension(pat.getSd_org());//组织号代码
		providerOrganization.setId(idProvider);
		providerOrganization.setName(pat.getName_org());//机构名称
		pr.setProviderOrganization(providerOrganization);
		recordTarget.setPatientRole(pr);
		return recordTarget;
	}
	
	/**
	 * 获取文档创作者
	 * @return
	 */
	private Author getAuthor(CiMrFpDTO pat)
	{
		Author author = new Author();
		author.setTypeCode("AUT");
		author.setContextControlCode("OP");
		if(pat.getDt_create()!=null)
			author.setTime(pat.getDt_create().getDate().toDate()); //创建时间
		else {
			author.setTime(null); //创建时间
		}
		AssignedAuthor assignedAuthor = new AssignedAuthor();
		assignedAuthor.setClassCode("ASSIGNED");

		Identification id = new Identification();
		id.setRoot("2.16.156.10011.1.7");
		id.setExtension(pat.getSd_author());//作者编号
		assignedAuthor.setId(id);
		ProviderOrganization assignedPerson = new ProviderOrganization();
		assignedPerson.setName(pat.getName_author());//作者姓名
		assignedAuthor.setAssignedPerson(assignedPerson);
		author.setAssignedAuthor(assignedAuthor);
		return author;
	}
	
	/**
	 * 获取保管机构
	 * @return
	 */
	private Custodian getCustodian(CiMrFpDTO pat)
	{
		Custodian custodian = new Custodian();
		custodian.setTypeCode("CST");
		AssignedCustodian assignedCustodian = new AssignedCustodian();
		assignedCustodian.setClassCode("ASSIGNED");
		ProviderOrganization representedCustodianOrganization = new ProviderOrganization();
		representedCustodianOrganization.setClassCode("ORG");
		representedCustodianOrganization.setDeterminerCode("INSTANCE");
		Identification id = new Identification();
		id.setRoot("2.16.156.10011.1.5");
		id.setExtension(pat.getSd_org());//缺少医疗卫生机构编号
		representedCustodianOrganization.setId(id);
		representedCustodianOrganization.setName(pat.getName_org());//医疗卫生机构名称
		assignedCustodian.setRepresentedCustodianOrganization(representedCustodianOrganization);
		custodian.setAssignedCustodian(assignedCustodian);
		return custodian;
		
	}
	
	/**
	 * 获取科主任签名 
	 */
	private DoctorNur getLegalAuthenticator(CiMrFpDTO pat)
	{
		DoctorNur doctorNur = new DoctorNur();
		DoctorNurEntity assignedEntity = new DoctorNurEntity();
		Identification id = new Identification();
		id.setRoot("2.16.156.10011.1.4");
		id.setExtension(pat.getSd_dirofdept());//sd
		assignedEntity.setId(id);
		Code code = new Code();
		code.setCode("1");
		code.setDisplayName("科主任");
		assignedEntity.setCode(code);
		ProviderOrganization assignedPeerson = new ProviderOrganization();
		assignedPeerson.setClassCode("PSN");
		assignedPeerson.setDeterminerCode("INSTANCE");
		assignedPeerson.setName(pat.getDirofdept());
		assignedEntity.setAssignedPeerson(assignedPeerson);
		doctorNur.setAssignedEntity(assignedEntity);
		return doctorNur;
	}
	
	/**
	 * 获取主(副主)任医师签名
	 */
	private DoctorNur getAuthenticator_zr(CiMrFpDTO pat)
	{
		DoctorNur doctorNur = new DoctorNur();
		DoctorNurEntity assignedEntity = new DoctorNurEntity();
		Identification id = new Identification();
		id.setRoot("2.16.156.10011.1.4");
		id.setExtension(pat.getSd_zr_doc());//sd
		assignedEntity.setId(id);
		Code code = new Code();
		code.setCode("2");
		code.setDisplayName("主任(副主任)医师");
		assignedEntity.setCode(code);
		ProviderOrganization assignedPeerson = new ProviderOrganization();
		assignedPeerson.setClassCode("PSN");
		assignedPeerson.setDeterminerCode("INSTANCE");
		assignedPeerson.setName(pat.getName_zr_doc());
		assignedEntity.setAssignedPeerson(assignedPeerson);
		doctorNur.setAssignedEntity(assignedEntity);
		return doctorNur;
	}
	
	/**
	 * 获取主治医师签名
	 */
	private DoctorNur getAuthenticator_zz(CiMrFpDTO pat)
	{
		DoctorNur doctorNur = new DoctorNur();
		DoctorNurEntity assignedEntity = new DoctorNurEntity();
		Identification id = new Identification();
		id.setRoot("2.16.156.10011.1.4");
		id.setExtension(pat.getSd_zz_doc());//缺少id
		assignedEntity.setId(id);
		Code code = new Code();
		code.setCode("3");
		code.setDisplayName("主治医师");
		assignedEntity.setCode(code);
		ProviderOrganization assignedPeerson = new ProviderOrganization();
		assignedPeerson.setClassCode("PSN");
		assignedPeerson.setDeterminerCode("INSTANCE");
		assignedPeerson.setName(pat.getName_zz_doc());
		assignedEntity.setAssignedPeerson(assignedPeerson);
		doctorNur.setAssignedEntity(assignedEntity);
		return doctorNur;
	}
	
	/**
	 * 获取住院医师签名
	 */
	private DoctorNur getAuthenticator_zy(CiMrFpDTO pat)
	{
		DoctorNur doctorNur = new DoctorNur();
		DoctorNurEntity assignedEntity = new DoctorNurEntity();
		Identification id = new Identification();
		id.setRoot("2.16.156.10011.1.4");
		id.setExtension(pat.getSd_zy_doc());//sd
		assignedEntity.setId(id);
		Code code = new Code();
		code.setCode("4");
		code.setDisplayName("住院医师");
		assignedEntity.setCode(code);
		ProviderOrganization assignedPeerson = new ProviderOrganization();
		assignedPeerson.setClassCode("PSN");
		assignedPeerson.setDeterminerCode("INSTANCE");
		assignedPeerson.setName(pat.getName_zy_doc());
		assignedEntity.setAssignedPeerson(assignedPeerson);
		doctorNur.setAssignedEntity(assignedEntity);
		return doctorNur;
	}
	
	/**
	 * 获取责任护士签名
	 */
	private DoctorNur getAuthenticator_zrhs(CiMrFpDTO pat)
	{
		DoctorNur doctorNur = new DoctorNur();
		DoctorNurEntity assignedEntity = new DoctorNurEntity();
		Identification id = new Identification();
		id.setRoot("2.16.156.10011.1.4");
		id.setExtension(pat.getSd_emp_nur());//sd
		assignedEntity.setId(id);
		Code code = new Code();
		code.setCode("5");
		code.setDisplayName("责任护士");
		assignedEntity.setCode(code);
		ProviderOrganization assignedPeerson = new ProviderOrganization();
		assignedPeerson.setClassCode("PSN");
		assignedPeerson.setDeterminerCode("INSTANCE");
		assignedPeerson.setName(pat.getName_emp_nur());
		assignedEntity.setAssignedPeerson(assignedPeerson);
		doctorNur.setAssignedEntity(assignedEntity);
		return doctorNur;
	}
	
	
	/**
	 * 获取进修医生签名
	 */
	private DoctorNur getAuthenticator_jx(CiMrFpDTO pat)
	{
		DoctorNur doctorNur = new DoctorNur();
		DoctorNurEntity assignedEntity = new DoctorNurEntity();
		Identification id = new Identification();
		id.setRoot("2.16.156.10011.1.4");
		id.setExtension(pat.getSd_learn_doc());//sd
		assignedEntity.setId(id);
		Code code = new Code();
		code.setCode("6");
		code.setDisplayName("进修医师");
		assignedEntity.setCode(code);
		ProviderOrganization assignedPeerson = new ProviderOrganization();
		assignedPeerson.setClassCode("PSN");
		assignedPeerson.setDeterminerCode("INSTANCE");
		assignedPeerson.setName(pat.getName_learn_doc());
		assignedEntity.setAssignedPeerson(assignedPeerson);
		doctorNur.setAssignedEntity(assignedEntity);
		return doctorNur;
	}
	
	
	/**
	 * 获取实习医生签名
	 */
	private DoctorNur getAuthenticator_sx(CiMrFpDTO pat)
	{
		DoctorNur doctorNur = new DoctorNur();
		DoctorNurEntity assignedEntity = new DoctorNurEntity();
		Identification id = new Identification();
		id.setRoot("2.16.156.10011.1.4");
		id.setExtension(pat.getSd_intern_doc());//sd
		assignedEntity.setId(id);
		Code code = new Code();
		code.setCode("7");
		code.setDisplayName("实习医师");
		assignedEntity.setCode(code);
		ProviderOrganization assignedPeerson = new ProviderOrganization();
		assignedPeerson.setClassCode("PSN");
		assignedPeerson.setDeterminerCode("INSTANCE");
		assignedPeerson.setName(pat.getName_intern_doc());
		assignedEntity.setAssignedPeerson(assignedPeerson);
		doctorNur.setAssignedEntity(assignedEntity);
		return doctorNur;
	}
	
	
	/**
	 * 获取编码员签名
	 */
	private DoctorNur getAuthenticator_bm(CiMrFpDTO pat)
	{
		DoctorNur doctorNur = new DoctorNur();
		DoctorNurEntity assignedEntity = new DoctorNurEntity();
		Identification id = new Identification();
		id.setRoot("2.16.156.10011.1.4");
		id.setExtension(pat.getSd_coder());//sd
		assignedEntity.setId(id);
		Code code = new Code();
		code.setCode("8");
		code.setDisplayName("编码员");
		assignedEntity.setCode(code);
		ProviderOrganization assignedPeerson = new ProviderOrganization();
		assignedPeerson.setClassCode("PSN");
		assignedPeerson.setDeterminerCode("INSTANCE");
		assignedPeerson.setName(pat.getName_coder());
		assignedEntity.setAssignedPeerson(assignedPeerson);
		doctorNur.setAssignedEntity(assignedEntity);
		return doctorNur;
	}
	
	/**
	 * 获取其他参与者（联系人）
	 * @return
	 */
	private Participant getParticipant(CiMrFpDTO pat)
	{
		Participant participant = new Participant();
		participant.setTypeCode("NOT");
		AssociatedEntity associatedEntity = new AssociatedEntity();
		associatedEntity.setClassCode("ECON");
		Code code = new Code();
		code.setCode(pat.getSd_conttp());
		code.setCodeSystem("2.16.156.10011.2.3.3.8");
		code.setDisplayName(pat.getName_conttp());
		code.setCodeSystemName("家庭关系代码表");
		associatedEntity.setCode(code);
		Address addr = this.getDetailAdderss(pat.getAddr_cont());
		addr.setUse("H");
		addr.setPostalCode("");//缺少邮编
		associatedEntity.setAddr(addr);
		CValue telecom = new CValue();
		telecom.setUse("H");
		telecom.setValue(pat.getTel_cont());
		associatedEntity.setTelecom(telecom);
		ProviderOrganization associatedPerson = new ProviderOrganization();
		associatedPerson.setClassCode("PSN");
		associatedPerson.setDeterminerCode("INSTANCE");
		associatedPerson.setName(pat.getName_cont());
		associatedEntity.setAssociatedPerson(associatedPerson);
		participant.setAssociatedEntity(associatedEntity);
		return participant;
	}
	
	/**
	 * 获取相关文档
	 * @return
	 */
	private RelatedDocument getRelatedDocument()
	{
		RelatedDocument relatedDocument = new RelatedDocument();
		relatedDocument.setTypeCode("RPLC");
		ParentDocument parentDocument = new ParentDocument();
		parentDocument.setId("");
		parentDocument.setIdSet("");
		parentDocument.setVersionNumber("");
		relatedDocument.setParentDocument(parentDocument);
		return relatedDocument;
	}
	
	/**
	 * 获取入院场景记录
	 * @return
	 */
	private ComponentOf getComponentOf(CiMrFpDTO pat)
	{
		ComponentOf componentOf = new ComponentOf();
		componentOf.setTypeCode("COMP");
		EncompassingEncounter encompassingEncounter = new EncompassingEncounter();
		encompassingEncounter.setClassCode("ENC");
		encompassingEncounter.setMoodCode("EVN");
		Code code = new Code();
		code.setCode(pat.getSd_referalsrc());
		code.setDisplayName(pat.getName_referalsrc());
		code.setCodeSystem("2.16.156.10011.2.3.1.270");
		code.setCodeSystemName("入院途径代码表");
		encompassingEncounter.setCode(code);
		EffectiveTime effectiveTime = new EffectiveTime();
		CValue low = new CValue();
		if(pat.getDt_acpt()==null)
			low.setValue(null);
		else
			low.setValue(pat.getDt_acpt().toLocalString());
		effectiveTime.setLow(low);
		CValue high =new  CValue();
		if(pat.getDt_end()==null)
			high.setValue(null);
		else
			high.setValue(pat.getDt_end().toLocalString());
		effectiveTime.setHigh(high);
		encompassingEncounter.setEffectiveTime(effectiveTime);
		Location location = new Location();
		location.setTypeCode("LOC");
		HealthCarFacility healthCarFacility = new HealthCarFacility();
		healthCarFacility.setClassCode("SDLOC");
		ServiceProviderOrganization serviceProviderOrganization = new ServiceProviderOrganization();
		serviceProviderOrganization.setClassCode("ORG");
		serviceProviderOrganization.setDeterminerCode("INSTANCE");
		OrganizaWard asOrganization = new OrganizaWard();
		asOrganization.setClassCode("PART");
		WholeOrganization wholeOrganization = new WholeOrganization();
		wholeOrganization.setClassCode("ORG");
		wholeOrganization.setDeterminerCode("INSTANCE");
		Identification id = new Identification();
		id.setRoot("2.16.156.10011.1.21");
		id.setExtension(pat.getIn_id_bed());
		wholeOrganization.setId(id);
		wholeOrganization.setName(pat.getName_in_bed());
		AsOrganizationPartOf asOrganizationPartOf = new AsOrganizationPartOf();
		asOrganizationPartOf.setClassCode("PART");
		ProviderOrganization wholeOrganizationSon = new ProviderOrganization();
		wholeOrganizationSon.setClassCode("ORG");
		wholeOrganizationSon.setDeterminerCode("INSTANCE");
		Identification idIn = new Identification();
		idIn.setRoot("2.16.156.10011.1.26");
		idIn.setExtension(pat.getSd_dep_phyadm());
		wholeOrganizationSon.setId(idIn);
		wholeOrganizationSon.setName(pat.getName_dep_phyadm());
		asOrganizationPartOf.setWholeOrganization(wholeOrganizationSon);
		wholeOrganization.setAsOrganizationPartOf(asOrganizationPartOf);
		asOrganization.setWholeOrganization(wholeOrganization);
		serviceProviderOrganization.setAsOrganization(asOrganization);
		healthCarFacility.setServiceProviderOrganization(serviceProviderOrganization);
		location.setHealthCarFacility(healthCarFacility);
		encompassingEncounter.setLocation(location);
		componentOf.setEncompassingEncounter(encompassingEncounter);
		return componentOf;
	}
	
	/**
	 * 获取文档体
	 */
	private StructuredBody getStructuredBody(CiMrFpMsgDTO cimrfp)
	{
		CiMrFpDTO pat =cimrfp.ciMrPat;
		StructuredBody structuredBody = new StructuredBody();
		structuredBody.setSectionLife(getSectionLifes(pat));
		structuredBody.setSectionDi(getSectionDis(pat));
		structuredBody.setSectionHel(getSectionHels(pat));
		structuredBody.setSectionChDep(getSectionChDeps(pat));
		structuredBody.setSectionOutHos(getSectionOutHoses(pat,cimrfp.di_xy));
		structuredBody.setSectionAlg(getSectionAlgs(pat));
		structuredBody.setSectionTest(getSectionTests(pat));
		structuredBody.setSectionSug(getSectionSugs((CiMrFpSugDTO[])cimrfp.sug.toArray()));
		structuredBody.setSectionIHH(getSectionIHHs(pat));
		structuredBody.setSectionIHC(getSectionIHCs(pat));
		structuredBody.setSectionQu(getSectionQus(pat));
		structuredBody.setSectionCP(getSectionCPs(pat));
		structuredBody.setSectionBL(getSectionBLs(pat));
		return structuredBody;
	}
	
	/**
	 * 生命体征章节
	 * @return
	 */
	private List<SectionLife> getSectionLifes(CiMrFpDTO pat)
	{
		List<SectionLife> sectionLifes = new ArrayList<SectionLife>();
		SectionLife life = new SectionLife();
		Code code = new Code();
		code.setCode("8716-3");
		code.setDisplayName("VITAL SIGNS");
		code.setCodeSystem("2.16.840.1.113883.6.1");
		code.setCodeSystemName("LOINC");
		life.setCode(code);
		List<EntryLife> entrys = getLifeEntries(pat);
		life.setEntry(entrys);
		sectionLifes.add(life);
		
		return sectionLifes;
	}

	/**
	 * 获取所有生命体征的实体
	 * @param pat
	 * @return
	 */
	private List<EntryLife> getLifeEntries(CiMrFpDTO pat) {
		List <EntryLife> entrys =new  ArrayList<EntryLife>();
		EntryLife entryIn  = new EntryLife();
		Observation observationIn = new Observation();
		observationIn.setClassCode("OBS");
		observationIn.setMoodCode("EVN");
		CodeLife codeIn = new CodeLife();
		codeIn.setCode("DE04.10.188.00");
		codeIn.setDisplayName("新生儿入院体重（g）");
		codeIn.setCodeSystem("2.16.156.10011.2.2.1");
		codeIn.setCodeSystemName("卫生信息数据元目录");		
		/*Qualifier qualifierIn = new Qualifier();
		CName nameIn =new CName();
		nameIn.setDisplayName("新生儿入院体重");
		qualifierIn.setName(nameIn);
		codeIn.setQualifier(qualifierIn);*/		
		observationIn.setCode(codeIn);
		CValue valueIn = new CValue();
		if(pat.getAddmission_weight()!=null)
			valueIn.setValue(pat.getAddmission_weight().toString());
		else
			valueIn.setValue("");
		valueIn.setUnit("g");
		observationIn.setValue(valueIn);
		entryIn.setObservation(observationIn);
		entrys.add(entryIn);
		EntryLife entryOut  = new EntryLife();
		Observation observationOut = new Observation();
		observationOut.setClassCode("OBS");
		observationOut.setMoodCode("EVN");
		CodeLife codeOut = new CodeLife();
		codeOut.setCode("DE04.10.019.00");
		codeOut.setDisplayName("新生儿出生体重（g）");
		codeOut.setCodeSystem("2.16.156.10011.2.2.1");
		codeOut.setCodeSystemName("卫生信息数据元目录");
		/*Qualifier qualifierOut = new Qualifier();
		CName nameOut =new CName();
		nameOut.setDisplayName("新生儿出生体重");
		qualifierOut.setName(nameOut);
		codeIn.setQualifier(qualifierOut);*/
		observationOut.setCode(codeOut);
		CValue valueOut = new CValue();
		if(pat.getBirth_weight() == null )
		{
			valueOut.setValue("");
		}
		else 
			valueOut.setValue(pat.getBirth_weight().toString());
		valueOut.setUnit("g");
		observationOut.setValue(valueOut);
		entryOut.setObservation(observationOut);
		entrys.add(entryOut);
		return entrys;
	}
	
	/**
	 * 诊断记录章节
	 * @return
	 */
	private List<SectionDi> getSectionDis(CiMrFpDTO pat)
	{
		List<SectionDi> sectionDis = new ArrayList<SectionDi>();
		SectionDi sectionDi = new SectionDi();
		Code code = new Code();
		code.setCode("29548-5");
		code.setDisplayName("Diagnosis");
		code.setCodeSystem("2.16.840.1.113883.6.1");
		code.setCodeSystemName("LOINC");
		sectionDi.setCode(code);
		List<EntryLife> entrys = new ArrayList<>();
		
		//门（急）诊诊断（中医诊断）名称
		EntryLife entry_di_cn = new EntryLife();
		Observation ob_di_cn = new Observation();
		ob_di_cn.setClassCode("OBS");
		ob_di_cn.setMoodCode("EVN");
		CodeLife code_di_cn = new CodeLife();
		code_di_cn.setCode("DE05.10.172.00");
		code_di_cn.setCodeSystem("2.16.156.10011.2.2.1");
		code_di_cn.setCodeSystemName("卫生信息数据元目录");
		code_di_cn.setDisplayName("门（急）诊诊断（中医诊断）名称");
		Qualifier qualifier_di_cn = new Qualifier();
		CName name_di_cn = new CName();
		name_di_cn.setDisplayName("中医诊断名称");
		qualifier_di_cn.setName(name_di_cn);
		code_di_cn.setQualifier(qualifier_di_cn);
		ob_di_cn.setCode(code_di_cn);
		ob_di_cn.setStrValue(pat.getName_outp_cm_di());
		entry_di_cn.setObservation(ob_di_cn);
		entrys.add(entry_di_cn);
		//门（急）诊诊断（中医诊断）名称sd	
		EntryLife entry_di_sd_cn = new EntryLife();//	
		Observation ob_di_sd_cn = new Observation();
		ob_di_sd_cn.setClassCode("OBS");
		ob_di_sd_cn.setMoodCode("EVN");
		CodeLife code_di_sd_cn = new CodeLife();
		code_di_sd_cn.setCode("DE05.10.130.00");
		code_di_sd_cn.setCodeSystem("2.16.156.10011.2.2.1");
		code_di_sd_cn.setCodeSystemName("卫生信息数据元目录");
		code_di_sd_cn.setDisplayName("门（急）诊诊断（中医诊断）病名编码");
		Qualifier qualifier_di_sd_cn = new Qualifier();
		CName name_di_sd_cn = new CName();
		name_di_sd_cn.setDisplayName("中医诊断代码");
		qualifier_di_sd_cn.setName(name_di_sd_cn);
		code_di_sd_cn.setQualifier(qualifier_di_sd_cn);
		ob_di_sd_cn.setCode(code_di_sd_cn);		
		Code value_di_sd_cn = new Code();
		value_di_sd_cn.setCode(pat.getSd_outp_cm_di());
		value_di_sd_cn.setCodeSystem("2.16.156.10011.2.3.3.14");
		value_di_sd_cn.setCodeSystemName("中医证候代码表（GB/T 15657）");
		value_di_sd_cn.setDisplayName("");//缺少症候名
		ob_di_sd_cn.setCvalue(value_di_sd_cn);
		entry_di_sd_cn.setObservation(ob_di_sd_cn);
		entrys.add(entry_di_sd_cn);
		//门（急）诊诊断-中医诊断证候名称条目
		EntryLife entry_di_zh = new EntryLife();//	
		Observation ob_di_zh = new Observation();
		ob_di_zh.setClassCode("OBS");
		ob_di_zh.setMoodCode("EVN");
		CodeLife code_di_zh = new CodeLife();
		code_di_zh.setCode("DE05.10.172.00");
		code_di_zh.setCodeSystem("2.16.156.10011.2.2.1");
		code_di_zh.setCodeSystemName("卫生信息数据元目录");
		code_di_zh.setDisplayName("门（急）诊诊断（中医证候）名称");
		Qualifier qualifier_di_zh = new Qualifier();
		CName name_di_zh = new CName();
		name_di_zh.setDisplayName("中医证候名称");
		qualifier_di_zh.setName(name_di_zh);
		code_di_zh.setQualifier(qualifier_di_zh);
		ob_di_zh.setCode(code_di_zh);
		ob_di_zh.setStrValue("");//缺症候名
		entry_di_zh.setObservation(ob_di_zh);
		entrys.add(entry_di_zh);
		//门（急）诊诊断-中医诊断证候编码条目
		EntryLife entry_di_sd_zh = new EntryLife();//	
		Observation ob_di_sd_zh = new Observation();
		ob_di_sd_zh.setClassCode("OBS");
		ob_di_sd_zh.setMoodCode("EVN");
		CodeLife code_di_sd_zh = new CodeLife();
		code_di_sd_zh.setCode("DE05.10.130.00");
		code_di_sd_zh.setCodeSystem("2.16.156.10011.2.2.1");
		code_di_sd_zh.setCodeSystemName("卫生信息数据元目录");
		code_di_sd_zh.setDisplayName("门（急）诊诊断（中医证候）证候编码");
		Qualifier qualifier_di_sd_zh = new Qualifier();
		CName name_di_sd_zh = new CName();
		name_di_sd_zh.setDisplayName("中医证候代码");
		qualifier_di_sd_zh.setName(name_di_sd_zh);
		code_di_sd_zh.setQualifier(qualifier_di_sd_zh);
		ob_di_sd_zh.setCode(code_di_sd_zh);		
		Code value_di_sd_zh = new Code();
		value_di_sd_zh.setCode("");//缺症候sd
		value_di_sd_zh.setCodeSystem("2.16.156.10011.2.3.3.14");
		value_di_sd_zh.setCodeSystemName("中医证候代码表（GB/T 15657）");
		value_di_sd_zh.setDisplayName("");//缺少症候名
		ob_di_sd_zh.setCvalue(value_di_sd_zh);
		entry_di_sd_zh.setObservation(ob_di_sd_zh);
		entrys.add(entry_di_sd_zh);
		
		//门（急）诊诊断名称
		EntryLife entry_di = new EntryLife();
		Observation ob_di = new Observation();
		ob_di.setClassCode("OBS");
		ob_di.setMoodCode("EVN");
		CodeLife code_di = new CodeLife();
		code_di.setCode("DE05.01.025.00");
		code_di.setCodeSystem("2.16.156.10011.2.2.1");
		code_di.setCodeSystemName("卫生信息数据元目录");
		code_di.setDisplayName("门（急）诊诊断名称");
		Qualifier qualifier_di = new Qualifier();
		CName name_di = new CName();
		name_di.setDisplayName("门（急）诊诊断");
		qualifier_di.setName(name_di);
		code_di.setQualifier(qualifier_di);
		ob_di.setCode(code_di);
		ob_di.setStrValue(pat.getName_outp_emer_di());
		entry_di.setObservation(ob_di);
		entrys.add(entry_di);
		//门（急）诊诊断sd	
		EntryLife entry_di_sd = new EntryLife();//	
		Observation ob_di_sd = new Observation();
		ob_di_sd.setClassCode("OBS");
		ob_di_sd.setMoodCode("EVN");
		CodeLife code_di_sd = new CodeLife();
		code_di_sd.setCode("DE05.01.024.00");
		code_di_sd.setCodeSystem("2.16.156.10011.2.2.1");
		code_di_sd.setCodeSystemName("卫生信息数据元目录");
		code_di_sd.setDisplayName("门（急）诊诊断疾病编码");
		Qualifier qualifier_di_sd = new Qualifier();
		CName name_di_sd = new CName();
		name_di_sd.setDisplayName("门（急）诊诊断");
		qualifier_di_sd.setName(name_di_sd);
		code_di_sd.setQualifier(qualifier_di_sd);
		ob_di_sd.setCode(code_di_sd);		
		Code value_di_sd_m = new Code();
		value_di_sd_m.setCode(pat.getSd_outp_emer_di());
		value_di_sd_m.setCodeSystem("2.16.156.10011.2.3.3.11");
		value_di_sd_m.setCodeSystemName("疾病代码表（ICD-10）");
		value_di_sd_m.setDisplayName(pat.getName_outp_emer_di());//
		ob_di_sd.setCvalue(value_di_sd_m);
		entry_di_sd.setObservation(ob_di_sd);
		entrys.add(entry_di_sd);
		
		//病理诊断-疾病名称
		EntryLife entry_dip = new EntryLife();//	
		Observation ob_dip = new Observation();
		ob_dip.setClassCode("OBS");
		ob_dip.setMoodCode("EVN");
		Identification id_dip = new Identification();
		id_dip.setRoot("2.16.156.10011.1.8");
		id_dip.setExtension("PA345677");
		ob_dip.setId(id_dip);		
		CodeLife code_dip = new CodeLife();
		code_dip.setCode("DE05.01.025.00");
		code_dip.setCodeSystem("2.16.156.10011.2.2.1");
		code_dip.setCodeSystemName("卫生信息数据元目录");
		code_dip.setDisplayName("病理诊断-疾病名称");
		Qualifier qualifier_dip = new Qualifier();
		CName name_dip = new CName();
		name_dip.setDisplayName("病理诊断名称");
		qualifier_dip.setName(name_dip);
		code_dip.setQualifier(qualifier_dip);
		ob_dip.setCode(code_dip);		
		ob_dip.setStrValue(pat.getName_dipathology());
		entry_dip.setObservation(ob_dip);
		entrys.add(entry_dip);
		
		//病理诊断-疾病编码
		EntryLife entry_dip_sd = new EntryLife();//	
		Observation ob_dip_sd = new Observation();
		ob_dip_sd.setClassCode("OBS");
		ob_dip_sd.setMoodCode("EVN");		
		CodeLife code_dip_sd = new CodeLife();
		code_dip_sd.setCode("DE05.01.024.00");
		code_dip_sd.setCodeSystem("2.16.156.10011.2.2.1");
		code_dip_sd.setCodeSystemName("卫生信息数据元目录");
		code_dip_sd.setDisplayName("病理诊断编码");
		Qualifier qualifier_dip_sd = new Qualifier();
		CName name_dip_sd = new CName();
		name_dip_sd.setDisplayName("病理诊断编码");
		qualifier_dip_sd.setName(name_dip_sd);
		code_dip_sd.setQualifier(qualifier_dip_sd);
		ob_dip_sd.setCode(code_dip_sd);		
		Code value_dip_sd = new Code();
		value_dip_sd.setCode(pat.getSd_dipathology());
		value_dip_sd.setCodeSystem("2.16.156.10011.2.3.3.11");
		value_dip_sd.setCodeSystemName("疾病代码表（ICD-10）");
		value_dip_sd.setDisplayName(pat.getName_dipathology());
		ob_dip_sd.setCvalue(value_dip_sd);
		entry_dip_sd.setObservation(ob_dip_sd);
		entrys.add(entry_dip_sd);		
		
		sectionDi.setEntry(entrys);
		sectionDis.add(sectionDi);
		OrganizerDi organizerDi = new OrganizerDi();
		//organizerDi.set
		//sectionDi.setOrganizerMz(organizerMz);
		return sectionDis;
	}
	
	/**
	 * 主要健康问题章节
	 * @return
	 */
	private List<SectionHel> getSectionHels(CiMrFpDTO pat)
	{
		List<SectionHel> sectionHels = new ArrayList<SectionHel>();
		SectionHel sectionHel = new SectionHel();
		Code code = new Code();
		code.setCode("11450-4");
		code.setDisplayName("PROBLEM LIST");
		code.setCodeSystem("2.16.840.1.113883.6.1");
		code.setCodeSystemName("LOINC");
		sectionHel.setCode(code);
		EntryLife entryCuType =  getHelEntryCuType(pat);
		sectionHel.setEntryCuType(entryCuType);
		EntryLife entryDip =  getHelEntryDip(pat);
		sectionHel.setEntryDip(entryDip);
		EntryLife entryStatus =  getHelEntryStatus(pat);
		sectionHel.setEntryStatus(entryStatus);
		
		/*EntryLife entry1 = new EntryLife();
		entry1.setTypeCode("COMP");
		Observation observation = getHelEntry1(pat);
		entry1.setObservation(observation);
		sectionHel.setEntry1(entry1);*/
		
		EntryHel entry2 = new EntryHel();
		entry2.setTypeCode("COMP");
		ObservationHel observationHel = getHelEntry2(pat);
		entry2.setObservation(observationHel);
		sectionHel.setEntry2(entry2);
		
		EntryHel2 entry3 = new EntryHel2();
		entry3.setTypeCode("COMP");
		OrganizerDi organizer = new OrganizerDi();
		List<ComponentSon> componets = getHelEntry3(pat, organizer);
		organizer.setComponent(componets);
		entry3.setOrganizer(organizer);
		sectionHel.setEntry3(entry3);
		
		EntryHel2 entry4 = new EntryHel2();
		entry4.setTypeCode("COMP");
		OrganizerDi organizer4 = new OrganizerDi();
		List<ComponentSon> componet4s = getHelEntry4(pat, organizer4);
		organizer4.setComponent(componet4s);
		entry4.setOrganizer(organizer4);
		sectionHel.setEntry4(entry4);;
		
		sectionHels.add(sectionHel);
		return sectionHels;
	}
	
	/**
	 * 住院者疾病状态代码表
	 * @param pat
	 * @return
	 */
	private EntryLife getHelEntryStatus(CiMrFpDTO pat) {
		EntryLife entryMainDi_Inp= new EntryLife();
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife code1 = new CodeLife();
		code1.setCode("DE05.10.119.00");
		code1.setCodeSystem("2.16.156.10011.2.2.1");
		code1.setCodeSystemName("卫生信息数据元目录");
		code1.setDisplayName("住院者疾病状态代码");
		observation.setCode(code1);		
		Code value = new Code();
		value.setCode("");//缺少值
		value.setCodeSystem("2.16.156.10011.2.3.2.57");
		value.setDisplayName("");//缺少值
		value.setCodeSystemName("住院者疾病状态代码表");
		observation.setCvalue(value);
		entryMainDi_Inp.setObservation(observation);
		return entryMainDi_Inp;
	}
	
	/**
	 * 实施临床路径
	 * @param pat
	 * @return
	 */
	private EntryLife getHelEntryDip(CiMrFpDTO pat) {
		EntryLife entryMainDi_Inp= new EntryLife();
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife code1 = new CodeLife();
		code1.setCode("HDSD00.12.099");
		code1.setCodeSystem("2.16.156.10011.2.2.1");
		code1.setCodeSystemName("卫生信息数据元目录");
		code1.setDisplayName("实施临床路径");
		observation.setCode(code1);		
		Code value = new Code();
		value.setCode(pat.getId_cipathtype());
		value.setCodeSystem("2.16.156.10011.2.3.2.57");
		value.setDisplayName(pat.getName_cipathtype());
		value.setCodeSystemName("实施临床路径标志代码表");
		observation.setCvalue(value);
		entryMainDi_Inp.setObservation(observation);
		return entryMainDi_Inp;
	}
	
	/**
	 * 治疗类别
	 * @param pat
	 * @return
	 */
	private EntryLife getHelEntryCuType(CiMrFpDTO pat) {
		EntryLife entryMainDi_Inp= new EntryLife();
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife code1 = new CodeLife();
		code1.setCode("DE06.00.304.00");
		code1.setCodeSystem("2.16.156.10011.2.2.1");
		code1.setCodeSystemName("卫生信息数据元目录");
		observation.setCode(code1);		
		Code value = new Code();
		value.setCode(pat.getSd_curecategory());
		value.setCodeSystem("2.16.156.10011.2.3.1.264");
		value.setDisplayName(pat.getName_curecategory());
		value.setCodeSystemName("治疗类别代码表");
		observation.setCvalue(value);
		entryMainDi_Inp.setObservation(observation);
		return entryMainDi_Inp;
	}
	
	/**
	 * 颅脑损伤患者入院后昏迷时间
	 * @param pat
	 * @param observation
	 * @param organizer
	 * @return
	 */
	private List<ComponentSon> getHelEntry4(CiMrFpDTO pat, OrganizerDi organizer) {
		organizer.setClassCode("CLUSTER");
		organizer.setMoodCode("EVN");
		Code code = new Code();
		code.setCode("2");
		code.setDisplayName("颅脑损伤患者入院后昏迷时间");
		organizer.setCode(code);
		List<ComponentSon> componets = new ArrayList<ComponentSon>();
		//颅脑损伤患者入院后昏迷时间-d
		ComponentSon componet = new ComponentSon();
		ObservationHel observation2 = new ObservationHel();
		observation2.setClassCode("OBS");
		observation2.setMoodCode("EVN");
		CodeLife code2 = new CodeLife();
		code2.setCode("DE05.10.138.01");
		code2.setCodeSystem("2.16.156.10011.2.2.1");
		code2.setCodeSystemName("卫生信息数据元目录");
		code2.setDisplayName("颅脑损伤患者入院后昏迷时间-d");
		observation2.setCode(code2);
		CValue value2 = new CValue();
		value2.setUnit("d");
		if(pat.getComa_time_inhos_days() == null)
			value2.setValue("0");
		else
			value2.setValue(pat.getComa_time_inhos_days().toString());
		observation2.setCValue(value2);
		componet.setObservation(observation2);
		componets.add(componet);
		//颅脑损伤患者入院后昏迷时间-h
		ComponentSon componetBH = new ComponentSon();
		ObservationHel observationBH = new ObservationHel();
		observationBH.setClassCode("OBS");
		observationBH.setMoodCode("EVN");
		CodeLife codeBH = new CodeLife();
		codeBH.setCode("DE05.10.138.02");
		codeBH.setCodeSystem("2.16.156.10011.2.2.1");
		codeBH.setCodeSystemName("卫生信息数据元目录");
		codeBH.setDisplayName("颅脑损伤患者入院后昏迷时间-h");
		observationBH.setCode(codeBH);
		CValue valueBH = new CValue();
		valueBH.setUnit("h");
		if(pat.getComa_time_inhos_hours()!=null)
			valueBH.setValue(pat.getComa_time_inhos_hours().toString());
		else
			valueBH.setValue("0");
		observationBH.setCValue(valueBH);
		componetBH.setObservation(observationBH);
		componets.add(componetBH);
		//颅脑损伤患者入院后昏迷时间-min
		ComponentSon componetBM = new ComponentSon();
		ObservationHel observationBM = new ObservationHel();
		observationBM.setClassCode("OBS");
		observationBM.setMoodCode("EVN");
		CodeLife codeBM = new CodeLife();
		codeBM.setCode("DE05.10.138.03");
		codeBM.setCodeSystem("2.16.156.10011.2.2.1");
		codeBM.setCodeSystemName("卫生信息数据元目录");
		codeBM.setDisplayName("颅脑损伤患者入院后昏迷时间-min");
		observationBM.setCode(codeBH);
		CValue valueBM = new CValue();
		valueBM.setUnit("min");
		if(pat.getComa_time_inhos_mins()==null)
			valueBM.setValue("0");
		else
			valueBM.setValue(pat.getComa_time_inhos_mins().toString());
		observationBM.setCValue(valueBM);
		componetBM.setObservation(observationBM);
		componets.add(componetBM);
		return componets;
	}
	
	/**
	 * 颅脑损伤患者入院前昏迷时间
	 * @param pat
	 * @param organizer
	 * @return
	 */
	private List<ComponentSon> getHelEntry3(CiMrFpDTO pat,OrganizerDi organizer) {
		organizer.setClassCode("CLUSTER");
		organizer.setMoodCode("EVN");
		Code code = new Code();
		code.setCode("1");
		code.setDisplayName("颅脑损伤患者入院前昏迷时间");
		organizer.setCode(code);
		List<ComponentSon> componets = new ArrayList<ComponentSon>();
		//颅脑损伤患者入院前昏迷时间-d
		ComponentSon componet = new ComponentSon();
		ObservationHel observation2 = new ObservationHel();
		observation2.setClassCode("OBS");
		observation2.setMoodCode("EVN");
		CodeLife code2 = new CodeLife();
		code2.setCode("DE05.10.138.01");
		code2.setCodeSystem("2.16.156.10011.2.2.1");
		code2.setCodeSystemName("卫生信息数据元目录");
		code2.setDisplayName("颅脑损伤患者入院前昏迷时间-d");
		observation2.setCode(code2);
		CValue value2 = new CValue();
		value2.setUnit("d");
		if(pat.getComa_time_bef_inhos_days()==null)
			value2.setValue("0");
		else
			value2.setValue(pat.getComa_time_bef_inhos_days().toString());
		observation2.setCValue(value2);
		componet.setObservation(observation2);
		componets.add(componet);
		//颅脑损伤患者入院前昏迷时间-h
		ComponentSon componetBH = new ComponentSon();
		ObservationHel observationBH = new ObservationHel();
		observationBH.setClassCode("OBS");
		observationBH.setMoodCode("EVN");
		CodeLife codeBH = new CodeLife();
		codeBH.setCode("DE05.10.138.02");
		codeBH.setCodeSystem("2.16.156.10011.2.2.1");
		codeBH.setCodeSystemName("卫生信息数据元目录");
		codeBH.setDisplayName("颅脑损伤患者入院前昏迷时间-h");
		observationBH.setCode(codeBH);
		CValue valueBH = new CValue();
		valueBH.setUnit("h");
		if(pat.getComa_time_bef_inhos_hours()==null)
			valueBH.setValue("0");
		else
			valueBH.setValue(pat.getComa_time_bef_inhos_hours().toString());
		observationBH.setCValue(valueBH);
		componetBH.setObservation(observationBH);
		componets.add(componetBH);
		//颅脑损伤患者入院前昏迷时间-min
		ComponentSon componetBM = new ComponentSon();
		ObservationHel observationBM = new ObservationHel();
		observationBM.setClassCode("OBS");
		observationBM.setMoodCode("EVN");
		CodeLife codeBM = new CodeLife();
		codeBM.setCode("DE05.10.138.03");
		codeBM.setCodeSystem("2.16.156.10011.2.2.1");
		codeBM.setCodeSystemName("卫生信息数据元目录");
		codeBM.setDisplayName("颅脑损伤患者入院前昏迷时间-min");
		observationBM.setCode(codeBH);
		CValue valueBM = new CValue();
		valueBM.setUnit("min");
		if(pat.getComa_time_bef_inhos_mins()==null)
			valueBM.setValue("0");
		else
			valueBM.setValue(pat.getComa_time_bef_inhos_mins().toString());
		observationBM.setCValue(valueBM);
		componetBM.setObservation(observationBM);
		componets.add(componetBM);
		return componets;
	}

	/**
	 * 获取住院患者损伤和中毒外部原因
	 * @param pat
	 * @return
	 */
	private ObservationHel getHelEntry2(CiMrFpDTO pat) {
		ObservationHel observationHel = new ObservationHel();
		observationHel.setClassCode("OBS");
		observationHel.setMoodCode("EVN");
		Code code2 = new Code();
		code2.setCode("DE05.10.152.00");
		code2.setDisplayName("损伤中毒的外部原因");
		code2.setCodeSystem("2.16.156.10011.2.2.1");
		code2.setCodeSystemName("卫生信息数据元目录");
		observationHel.setCode(code2);
		observationHel.setValue(pat.getName_iioutreason());
		List<EntryRelationship> entryRelationships = new ArrayList<EntryRelationship>();
		EntryRelationship entyRelationship = new EntryRelationship();
		entyRelationship.setTypeCode("REFR");
		entyRelationship.setNegationInd("false");
		Observation observation2 = new Observation();
		observation2.setClassCode("OBS");
		observation2.setMoodCode("EVN");
		CodeLife code3 = new CodeLife();
		code3.setCode("DE05.01.078.00");
		code3.setCodeSystem("2.16.156.10011.2.2.1");
		code3.setCodeSystemName("卫生信息数据元目录");
		code3.setDisplayName("损伤中毒的外部原因-疾病编码");
		observation2.setCode(code3);
		Code cValue = new Code();
		cValue.setCode(pat.getSd_iioutreason());
		cValue.setCodeSystem("2.16.156.10011.2.3.3.11.5");
		cValue.setCodeSystemName("疾病代码表（ICD-10）");
		observation2.setCvalue(cValue);
		entyRelationship.setObservation(observation2);
		entryRelationships.add(entyRelationship);
		observationHel.setEntyRelationship(entryRelationships);
		return observationHel;
	}

	/**
	 * 获取住院者疾病状态
	 * @return
	 */
	private Observation getHelEntry1(CiMrFpDTO pat) {
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife code1 = new CodeLife();
		code1.setCode("DE05.10.119.00");
		code1.setCodeSystem("2.16.156.10011.2.2.1");
		code1.setCodeSystemName("卫生信息数据元目录");
		code1.setDisplayName("住院者疾病状态代码");
		observation.setCode(code1);
		Code value = new Code();
		value.setCode("");//缺少住院者疾病状态代码
		value.setCodeSystem("2.16.156.10011.2.3.1.100");
		value.setCodeSystemName("住院者疾病状态代码表");
		value.setDisplayName("");//住院者疾病状态名称
		observation.setCvalue(value);
		return observation;
	}
	
	/**
	 * 转科记录章节
	 * @return
	 */
	private List<SectionChDep> getSectionChDeps(CiMrFpDTO pat)
	{
		List<SectionChDep> sectionChDeps = new ArrayList<SectionChDep>();
		SectionChDep sectionChDep = new SectionChDep();
		Code code = new Code();
		code.setCode("42349-1");
		code.setDisplayName("REASON FOR REFERRAL");
		code.setCodeSystem("2.16.840.1.113883.6.1");
		code.setCodeSystemName("LOINC");
		sectionChDep.setCode(code);
		List<ObserVationChDep> observations = new ArrayList<ObserVationChDep>();
		ObserVationChDep obserVationChDep = new ObserVationChDep();
		obserVationChDep.setClassCode("OBS");
		obserVationChDep.setMoodCode("EVN");
		AuthorChDep author = new AuthorChDep();
		AssignedAuthorChDep assignedAuthor = new AssignedAuthorChDep();		
		//assignedAuthor.setId(id);
		ProviderOrganization representedOrganization1 = new ProviderOrganization();
		Identification id = new Identification();
		id.setRoot("2.16.156.10011.1.26");
		id.setExtension(pat.getSd_dep_trans());
		representedOrganization1.setId(id);
		representedOrganization1.setName(pat.getName_dep_trans());
		assignedAuthor.setRepresentedOrganization1(representedOrganization1);
		author.setAssignedAuthor(assignedAuthor);
		obserVationChDep.setAuthor(author);
		observations.add(obserVationChDep);
		sectionChDep.setObservation(observations);
		sectionChDeps.add(sectionChDep);
		return sectionChDeps;
	}
	
	/**
	 * 出院诊断章节
	 * @return
	 */
	private List<SectionOutHos> getSectionOutHoses(CiMrFpDTO pat, List<CiMrFpXYDIDTO> lstDi_xy)
	{
		List<SectionOutHos> sectionOutHoses = new ArrayList<SectionOutHos>();
		SectionOutHos sectionOutHos = new SectionOutHos();
		Code code = new Code();
		code.setCode("11535-2");
		code.setDisplayName("Discharge Diagnosis");
		code.setCodeSystem("2.16.840.1.113883.6.1");
		code.setCodeSystemName("LOINC");
		sectionOutHos.setCode(code);
		EntryHel entry_OutHos = getOutHosType(pat);
		sectionOutHos.setEntry_OutHos(entry_OutHos);	
		EntryLife entry_NameOutHos =  getNameOutHos(pat);
		sectionOutHos.setEntry_NameOutHos(entry_NameOutHos);	
		if(lstDi_xy!=null)
		{
			if(lstDi_xy.size()>0)
			{
				int index =0;//如果没有主诊断为0，否则为1
				CiMrFpXYDIDTO di_xyMain = lstDi_xy.get(0);
				if(di_xyMain.getFg_maindi()!=null&&di_xyMain.getFg_maindi() == FBoolean.TRUE)
				{
					EntryLife entryMainDi_Name = getXyDiMainName(di_xyMain);
					sectionOutHos.setEntryMainDi_Name(entryMainDi_Name);
					EntryLife entryMainDi_Sd = getXyDiMainSd(di_xyMain);
					sectionOutHos.setEntryMainDi_Sd(entryMainDi_Sd);
					EntryLife entryMainDi_inp = getXyDiMainInp(di_xyMain);
					sectionOutHos.setEntryMainDi_inp(entryMainDi_inp);
					index=1;
				}
				//其他诊断
				List<EntryHel> entrys = new ArrayList<EntryHel>();
				for(int i=index;i<lstDi_xy.size();i++)
				{
					EntryHel entry = getXyDiOther(lstDi_xy, i);
					entrys.add(entry);
				}
				sectionOutHos.setEntrys(entrys);
			}
			
		}
		sectionOutHoses.add(sectionOutHos);
		return sectionOutHoses;
	}

	/**
	 * 获取其他诊断
	 * @param lstDi_xy
	 * @param i
	 * @return
	 */
	private EntryHel getXyDiOther(List<CiMrFpXYDIDTO> lstDi_xy, int i) {
		CiMrFpXYDIDTO di_xyOther = lstDi_xy.get(i);
		EntryHel entry = new EntryHel();
		ObservationHel observation = new ObservationHel();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife codeQua = new CodeLife();
		codeQua.setCode("DE05.01.025.00");
		codeQua.setCodeSystem("2.16.156.10011.2.2.1");
		codeQua.setCodeSystemName("卫生信息数据元目录");
		Qualifier qualifier = new Qualifier();
		CName name = new CName();
		name.setDisplayName("其他诊断名称");
		qualifier.setName(name);
		codeQua.setQualifier(qualifier);
		observation.setCodeQua(codeQua);
		observation.setValue(di_xyOther.getName_di());
		
		List<EntryRelationship> entyRelationships=new ArrayList<EntryRelationship>();
		EntryRelationship di_sd = new EntryRelationship();
		di_sd.setTypeCode("COMP");
		Observation observation_sd  = new Observation(); 
		observation_sd.setClassCode("OBS");
		observation_sd.setMoodCode("EVN");
		CodeLife code_sd = new CodeLife();
		code_sd.setCode("DE05.01.024.00");
		code_sd.setCodeSystem("2.16.156.10011.2.2.1");
		code_sd.setCodeSystemName("卫生信息数据元目录");
		code_sd.setDisplayName("西医出院诊断-其他诊断疾病编码");
		Qualifier qualifier_sd = new Qualifier();
		CName name_sd = new CName();
		name_sd.setDisplayName("其他诊断疾病编码");
		qualifier_sd.setName(name_sd);
		code_sd.setQualifier(qualifier_sd);
		observation_sd.setCode(code_sd);
		Code cvalue_sd = new Code();
		cvalue_sd.setCode(di_xyOther.getSd_di());
		cvalue_sd.setDisplayName(di_xyOther.getName_di());
		cvalue_sd.setCodeSystem("2.16.156.10011.2.3.3.11.3");
		cvalue_sd.setCodeSystemName("ICD-10");
		observation_sd.setCvalue(cvalue_sd);
		di_sd.setObservation(observation_sd);
		entyRelationships.add(di_sd);
		//入院病情
		EntryRelationship di_Inp = new EntryRelationship();
		di_Inp.setTypeCode("COMP");
		Observation observation_Inp  = new Observation(); 
		observation_Inp.setClassCode("OBS");
		observation_Inp.setMoodCode("EVN");
		CodeLife code_Inp = new CodeLife();
		code_Inp.setCode("DE09.00.104.00");
		code_Inp.setCodeSystem("2.16.156.10011.2.2.1");
		code_Inp.setCodeSystemName("卫生信息数据元目录");
		code_Inp.setDisplayName("出院西医诊断-其他诊断-入院病情代码");
		Qualifier qualifier_Inp = new Qualifier();
		CName name_Inp = new CName();
		name_Inp.setDisplayName("其他诊断-入院病情代码");
		qualifier_Inp.setName(name_Inp);
		code_Inp.setQualifier(qualifier_Inp);
		observation_Inp.setCode(code_Inp);
		Code cvalue_Inp = new Code();
		if(di_xyOther.getId_dislvl_inp()!=null)
			cvalue_Inp.setCode(di_xyOther.getId_dislvl_inp().toString());
		else {
			cvalue_Inp.setCode("");
		}
		cvalue_Inp.setDisplayName("");//没有入院名称
		cvalue_Inp.setCodeSystem("2.16.156.10011.2.3.1.253");
		cvalue_Inp.setCodeSystemName("入院病情代码表");
		observation_Inp.setCvalue(cvalue_Inp);
		di_Inp.setObservation(observation_Inp);
		entyRelationships.add(di_Inp);					
		observation.setEntyRelationship(entyRelationships);					
		entry.setObservation(observation);
		return entry;
	}

	/**
	 * 西医主诊断入院情况
	 * @param di_xyMain
	 * @return
	 */
	private EntryLife getXyDiMainInp(CiMrFpXYDIDTO di_xyMain) {
		EntryLife entryMainDi_Inp= new EntryLife();
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife code1 = new CodeLife();
		code1.setCode("DE09.00.104.00");
		code1.setCodeSystem("2.16.156.10011.2.2.1");
		code1.setCodeSystemName("卫生信息数据元目录");
		code1.setDisplayName("出院诊断-主要诊断入院病情代码");
		Qualifier qualifier_MainName = new Qualifier();
		CName name_MainName = new CName();
		name_MainName.setDisplayName("主要诊断入院病情代码");
		qualifier_MainName.setName(name_MainName);
		code1.setQualifier(qualifier_MainName);
		observation.setCode(code1);
		CValue effectiveTime = new CValue();
		effectiveTime.setValue("");//没有时间
		observation.setEffectiveTime(effectiveTime);		
		Code value = new Code();
		if(di_xyMain.getId_dislvl_inp()!=null)
			value.setCode(di_xyMain.getId_dislvl_inp().toString());
		else {
			value.setCode("");
		}
		value.setCodeSystem("2.16.156.10011.2.3.3.11.3");
		value.setDisplayName(di_xyMain.getName_dislvl_inp());//没有值
		value.setCodeSystemName("入院病情代码表");
		observation.setCvalue(value);
		entryMainDi_Inp.setObservation(observation);
		return entryMainDi_Inp;
	}
	
	/**
	 * 西医主诊断编码
	 * @param di_xyMain
	 * @return
	 */
	private EntryLife getXyDiMainSd(CiMrFpXYDIDTO di_xyMain) {
		EntryLife entryMainDi_Sd = new EntryLife();
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife code1 = new CodeLife();
		code1.setCode("DE05.01.024.00");
		code1.setCodeSystem("2.16.156.10011.2.2.1");
		code1.setCodeSystemName("卫生信息数据元目录");
		code1.setDisplayName("出院诊断-主要诊断疾病编码");
		Qualifier qualifier_MainName = new Qualifier();
		CName name_MainName = new CName();
		name_MainName.setDisplayName("主要诊断编码");
		qualifier_MainName.setName(name_MainName);
		code1.setQualifier(qualifier_MainName);
		observation.setCode(code1);
		CValue effectiveTime = new CValue();
		effectiveTime.setValue("");//没有时间
		observation.setEffectiveTime(effectiveTime);		
		Code value = new Code();
		value.setCode(di_xyMain.getSd_di());
		value.setCodeSystem("2.16.156.10011.2.3.3.11.3");
		value.setCodeSystemName("诊断代码表（ICD-10）");
		observation.setCvalue(value);
		entryMainDi_Sd.setObservation(observation);
		return entryMainDi_Sd;
	}
	
	/**
	 * 西医主诊断名称
	 * @param di_xyMain
	 * @return
	 */
	private EntryLife getXyDiMainName(CiMrFpXYDIDTO di_xyMain) {
		EntryLife entryMainDi_Name = new EntryLife();
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife code1 = new CodeLife();
		code1.setCode("DE05.01.025.00");
		code1.setCodeSystem("2.16.156.10011.2.2.1");
		code1.setCodeSystemName("卫生信息数据元目录");
		code1.setDisplayName("出院中医诊断-主病名称");
		Qualifier qualifier_MainName = new Qualifier();
		CName name_MainName = new CName();
		name_MainName.setDisplayName("主要诊断名称");
		qualifier_MainName.setName(name_MainName);
		code1.setQualifier(qualifier_MainName);
		observation.setCode(code1);
		CValue effectiveTime = new CValue();
		effectiveTime.setValue("");//没有时间
		observation.setEffectiveTime(effectiveTime);
		observation.setStrValue(di_xyMain.getName_di());
		entryMainDi_Name.setObservation(observation);
		return entryMainDi_Name;
	}

	/**
	 *离院方式拟接受医疗机构名称
	 * @param di_xyMain
	 * @return
	 */
	private EntryLife getNameOutHos(CiMrFpDTO pat) {
		EntryLife entryMainDi_Name = new EntryLife();
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife code1 = new CodeLife();
		code1.setCode("DE08.10.013.00");
		code1.setCodeSystem("2.16.156.10011.2.2.1");
		code1.setCodeSystemName("卫生信息数据元目录");
		code1.setDisplayName("拟接受医疗机构名称");
		observation.setCode(code1);
		if(pat.getOut_hos_mode()!=null&&pat.getOut_hos_mode() =="2" )
			observation.setStrValue(pat.getName_med_in_1());
		else if(pat.getOut_hos_mode()!=null&&pat.getOut_hos_mode() =="3" )
			observation.setStrValue(pat.getName_med_in_2());
		entryMainDi_Name.setObservation(observation);
		return entryMainDi_Name;
	}
	
	/**
	 * 离院方式
	 * @param pat
	 * @return
	 */
	private EntryHel getOutHosType(CiMrFpDTO pat) {
		EntryHel entry_OutHos = new EntryHel();
		entry_OutHos.setTypeCode("COMP");
		ObservationHel observation_out = new ObservationHel();
		observation_out.setClassCode("OBS");
		observation_out.setMoodCode("EVN");
		Code code_out = new Code();
		code_out.setCode("DE06.00.223.00");
		code_out.setCodeSystem("2.16.156.10011.2.2.1");
		code_out.setCodeSystemName("卫生信息数据元目录");
		code_out.setDisplayName("离院方式");
		observation_out.setCode(code_out);
		Code codeValue_out = new Code();
		codeValue_out.setCode(pat.getOut_hos_mode());
		codeValue_out.setDisplayName(pat.getName_out_hos_mode());
		codeValue_out.setCodeSystem("2.16.156.10011.2.3.1.265");
		codeValue_out.setCodeSystemName("离院方式代码表");
		observation_out.setCodeValue(codeValue_out);
		/*List<EntryRelationship> entyRelationship_outs = new ArrayList<EntryRelationship>();
		EntryRelationship entryRelationship_out = new EntryRelationship();
		entryRelationship_out.setTypeCode("COMP");
		entryRelationship_out.setNegationInd("false");
		Observation observation_outSon = new Observation();
		observation_outSon.setClassCode("OBS");
		observation_outSon.setMoodCode("EVN");
		CodeLife code_outName = new CodeLife();
		code_outName.setCode("DE08.10.013.00");
		code_outName.setCodeSystem("2.16.156.10011.2.2.1");
		code_outName.setCodeSystemName("卫生信息数据元目录");
		code_outName.setDisplayName("拟接受医疗机构名称");
		observation_outSon.setCode(code_outName);
		if(pat.getOut_hos_mode()!=null&&pat.getOut_hos_mode() =="2" )
			observation_outSon.setStrValue(pat.getName_med_in_1());
		else if(pat.getOut_hos_mode()!=null&&pat.getOut_hos_mode() =="3" )
			observation_outSon.setStrValue(pat.getName_med_in_2());
		entryRelationship_out.setObservation(observation_outSon);
		entyRelationship_outs.add(entryRelationship_out);
		observation_out.setEntyRelationship(entyRelationship_outs);*/
		entry_OutHos.setObservation(observation_out);
		return entry_OutHos;
	}
	
	/**
	 * 过敏史章节
	 * @return
	 */
	private List<SectionAlg> getSectionAlgs(CiMrFpDTO pat)
	{
		List<SectionAlg> sectionAlgs = new ArrayList<SectionAlg>();
		SectionAlg sectionAlg = new SectionAlg();
		Code code = new Code();
		code.setCode("48765-2");
		code.setDisplayName("Allergies, adverse reactions, alerts");
		code.setCodeSystem("2.16.840.1.113883.6.1");
		code.setCodeSystemName("LOINC");
		sectionAlg.setCode(code);
		EntryAlg entry = new EntryAlg();
		ActAlg act = new ActAlg();
		act.setClassCode("ACT");
		act.setMoodCode("EVN");
		EntryRelationshipAlg entryRelationship = new EntryRelationshipAlg();
		entryRelationship.setTypeCode("SUBJ");
		ObservationAlg observation = new ObservationAlg();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		Code codeA = new Code();
		codeA.setCode("DE02.10.023.00");
		codeA.setCodeSystem("2.16.156.10011.2.2.1");
		codeA.setCodeSystemName("卫生信息数据元目录");
		observation.setCode(codeA);
		CValue value = new CValue();
		value.setValue(pat.getName_drug_allergy());//name还是sd,现在是编码
		observation.setValue(value);
		ParticipantAlg participant = new ParticipantAlg();
		participant.setTypeCode("CSM");
		ParticipantRole participantRole = new ParticipantRole();
		participantRole.setClassCode("MANU");
		PlayingEntity playingEntity = new PlayingEntity();
		playingEntity.setClassCode("MANU");
		Code codeP = new Code();
		codeP.setCode("DE02.10.022.00");
		codeP.setCodeSystem("2.16.156.10011.2.2.1");
		codeP.setCodeSystemName("卫生信息数据元目录");
		codeP.setDisplayName("过敏药物");
		playingEntity.setCode(codeP);
		playingEntity.setDesc(pat.getAllergic_drugs());
		participantRole.setPlayingEntity(playingEntity);
		participant.setParticipantRole(participantRole);
		observation.setParticipant(participant);
		entryRelationship.setObservation(observation);
		act.setEntryRelationship(entryRelationship);
		entry.setAct(act);
		sectionAlg.setEntry(entry);
		sectionAlgs.add(sectionAlg);
		return sectionAlgs;
	}
	
	/**
	 * 实验室检验章节
	 * @return
	 */
	private List<SectionDi> getSectionTests(CiMrFpDTO pat)
	{
		List<SectionDi> sectionTests = new ArrayList<SectionDi>();
		SectionDi sectionTest = new SectionDi();
		CodeLife code = new CodeLife();
		code.setCode("30954-2");
		code.setDisplayName("STUDIES SUMMARY");
		code.setCodeSystem("2.16.840.1.113883.6.1");
		code.setCodeSystemName("LOINC");		
		sectionTest.setCode(code);
		List<OrganizerDi> organizers = new ArrayList<OrganizerDi>();
		OrganizerDi organizer = new OrganizerDi();
		organizer.setClassCode("BATTERY");
		organizer.setMoodCode("EVN");
		List<ComponentSon> components = new ArrayList<ComponentSon>();
		ComponentSon comBlood = new ComponentSon();
		getBloodMsgABO(pat, comBlood);
		components.add(comBlood);
		
		ComponentSon comRh = new ComponentSon();
		getBloodMsgRh(pat, comRh);
		components.add(comRh);
		
		organizer.setComponent(components);
		organizers.add(organizer);
		sectionTest.setOrganizerBl(organizers);
		
		sectionTests.add(sectionTest);
		return sectionTests;
	}

	/**
	 * Rh血型
	 * @param pat
	 * @param comRh
	 */
	private void getBloodMsgRh(CiMrFpDTO pat, ComponentSon comRh) {
		comRh.setTypeCode("COMP");
		comRh.setContextConductionInd("true");
		ObservationHel observationRh = new ObservationHel();
		observationRh.setClassCode("OBS");
		observationRh.setMoodCode("EVN");
		CodeLife codeRh = new CodeLife();
		codeRh.setCode("DE04.50.001.00");
		codeRh.setCodeSystem("2.16.156.10011.2.2.2");
		codeRh.setCodeSystemName("卫生信息数据元目录");
		observationRh.setCode(codeRh);
		Code CvlueRh = new Code();
		CvlueRh.setCode(pat.getId_rh_type());
		CvlueRh.setCodeSystem("2.16.156.10011.2.3.1.250");
		CvlueRh.setCodeSystemName("Rh血型代码表");
		CvlueRh.setDisplayName(pat.getName_rh_type());
		observationRh.setCodeValue(CvlueRh);
		comRh.setObservation(observationRh);
	}

	/**
	 * ABO血型
	 * @param pat
	 * @param comBlood
	 */
	private void getBloodMsgABO(CiMrFpDTO pat, ComponentSon comBlood) {
		comBlood.setTypeCode("COMP");
		comBlood.setContextConductionInd("true");
		ObservationHel observation = new ObservationHel();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife codeBlood = new CodeLife();
		codeBlood.setCode("DE04.50.001.00");
		codeBlood.setCodeSystem("2.16.156.10011.2.2.1");
		codeBlood.setCodeSystemName("卫生信息数据元目录");
		observation.setCode(codeBlood);
		Code CvlueB = new Code();
		CvlueB.setCode(pat.getId_blood_type());
		CvlueB.setCodeSystem("2.16.156.10011.2.3.1.85");
		CvlueB.setCodeSystemName("ABO血型代码表");
		CvlueB.setDisplayName(pat.getName_blood_type());
		observation.setCodeValue(CvlueB);
		comBlood.setObservation(observation);
	}
	
	/**
	 * 手术操作章节
	 * @return
	 */
	private List<SectionSug> getSectionSugs(CiMrFpSugDTO[] sugDTOs)
	{
		List<SectionSug> sectionSugs = new ArrayList<SectionSug>();
		SectionSug sug = new SectionSug();
		Code code = new Code();
		code.setCode("47519-4");
		code.setDisplayName("HISTORY OF PROCEDURES");
		code.setCodeSystem("2.16.840.1.113883.6.1");
		code.setCodeSystemName("LOINC");
		sug.setCode(code);
		List<EntrySug> entrySugs = new ArrayList<EntrySug>();
		if(sugDTOs!=null&&sugDTOs.length>0)
		{
			for(int i =0;i<sugDTOs.length;i++)
			{
				EntrySug entrySug = new EntrySug();
				ProcedureSug procedure = new ProcedureSug();
				procedure.setClassCode("PROC");
				procedure.setMoodCode("EVN");
				Code codeSug = new Code();
				codeSug.setCode(sugDTOs[i].getSd_sug());
				codeSug.setCodeSystem("2.16.156.10011.2.3.3.12");
				codeSug.setCodeSystemName("手术(操作)代码表（ICD-9-CM）");
				procedure.setCode(codeSug);
				CValue effectiveTime = new CValue();
				if(sugDTOs[i].getDt_start_sug()==null)
					effectiveTime.setValue(null);
				else
					effectiveTime.setValue(sugDTOs[i].getDt_start_sug().toLocalString());
				procedure.setEffectiveTime(effectiveTime);
				List<AssignedAuthor> assignedEntitys = new ArrayList<AssignedAuthor>();
				getSugPerformer(sugDTOs, i, assignedEntitys);
				procedure.setAssignedEntity(assignedEntitys);
				ParticipantAlg participant1 = new ParticipantAlg();
				getSugAssistant1(sugDTOs, i, participant1);
				procedure.setParticipant1(participant1);
				ParticipantAlg participant2 = new ParticipantAlg();
				getSugAssistant2(sugDTOs, i, participant2);
				procedure.setParticipant2(participant2);
				EntryRelationship entryRelationshipName = new EntryRelationship();
				getSugName(sugDTOs, i, entryRelationshipName);
				procedure.setEntryRelationshipName(entryRelationshipName);
				EntryRelationship entryRelationshipLvl = new EntryRelationship();
				getSugLvl(sugDTOs, i, entryRelationshipLvl);
				procedure.setEntryRelationshipLvl(entryRelationshipLvl);
				EntryRelationship entryRelationshipInLvl = new EntryRelationship();
				getSugInLvl(sugDTOs, i, entryRelationshipInLvl);
				procedure.setEntryRelationshipInLvl(entryRelationshipInLvl);
				EntryRelationship entryRelationshipInGLvl = new EntryRelationship();
				getSugInInGLvl(sugDTOs, i, entryRelationshipInGLvl);
				procedure.setEntryRelationshipInGLvl(entryRelationshipInGLvl);
				EntryRelationshipSug entryRelationshipAn = new EntryRelationshipSug();
				entryRelationshipAn.setTypeCode("COMP");
				getSugAn(sugDTOs, i, entryRelationshipAn);
				procedure.setEntryRelationshipAn(entryRelationshipAn);
				entrySug.setProcedure(procedure);
				entrySugs.add(entrySug);
			}
		}
		sug.setEntrySugs(entrySugs);
		sectionSugs.add(sug);
		return sectionSugs;
	}

	/**
	 * 麻醉信息
	 * @param sugDTOs
	 * @param i
	 * @param entryRelationshipAn
	 */
	private void getSugAn(CiMrFpSugDTO[] sugDTOs, int i,
			EntryRelationshipSug entryRelationshipAn) {
		ObservationSug observationAn = new ObservationSug();
		observationAn.setClassCode("OBS");
		observationAn.setMoodCode("EVN");
		CodeLife codeAn = new CodeLife();
		codeAn.setCode("DE06.00.073.00");
		codeAn.setCodeSystem("2.16.156.10011.2.2.1");
		codeAn.setCodeSystemName("卫生信息数据元目录");
		codeAn.setDisplayName("麻醉方法代码");
		observationAn.setCode(codeAn);
		Code cValue = new Code();
		cValue.setCode(sugDTOs[i].getSd_anestp());
		cValue.setCodeSystem("2.16.156.10011.2.3.1.159");
		cValue.setCodeSystemName("麻醉方法代码表");
		observationAn.setCValue(cValue);
		List<AssignedAuthor> assignedEntityAns = new ArrayList<AssignedAuthor>();
		AssignedAuthor AssignedAn = new AssignedAuthor();
		Identification idAn = new Identification();
		idAn.setRoot("2.16.156.10011.1.4");
		idAn.setExtension(sugDTOs[i].getSd_emp_anes());
		AssignedAn.setId(idAn);
		ProviderOrganization assignedPerson = new ProviderOrganization();
		assignedPerson.setName(sugDTOs[i].getName_emp_anes());
		AssignedAn.setAssignedPerson(assignedPerson);
		assignedEntityAns.add(AssignedAn);
		observationAn.setAssignedEntity(assignedEntityAns);
		entryRelationshipAn.setObservation(observationAn);
	}

	/**
	 * 手术切口愈合等级
	 * @param sugDTOs
	 * @param i
	 * @param entryRelationshipInLvl
	 */
	private void getSugInInGLvl(CiMrFpSugDTO[] sugDTOs, int i,
			EntryRelationship entryRelationshipInLvl) {
		entryRelationshipInLvl.setTypeCode("COMP");
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife cName = new CodeLife();
		cName.setCode("DE05.10.147.00");
		cName.setCodeSystem("2.16.156.10011.2.2.1");
		cName.setCodeSystemName("卫生信息数据元目录");
		cName.setDisplayName("手术切口愈合等级");
		observation.setCode(cName);
		Code value = new Code();
		value.setCode(sugDTOs[i].getSd_incicondi());
		value.setCodeSystem("2.16.156.10011.2.3.1.257");
		value.setCodeSystemName("手术切口愈合等级代码表");
		value.setDisplayName(sugDTOs[i].getName_incicondi());
		observation.setCvalue(value);;
		entryRelationshipInLvl.setObservation(observation);
	}
	
	/**
	 * 手术切口类别
	 * @param sugDTOs
	 * @param i
	 * @param entryRelationshipInLvl
	 */
	private void getSugInLvl(CiMrFpSugDTO[] sugDTOs, int i,
			EntryRelationship entryRelationshipInLvl) {
		entryRelationshipInLvl.setTypeCode("COMP");
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife cName = new CodeLife();
		cName.setCode("DE06.00.257.00");
		cName.setCodeSystem("2.16.156.10011.2.2.1");
		cName.setCodeSystemName("卫生信息数据元目录");
		cName.setDisplayName("手术切口类别代码");
		observation.setCode(cName);
		Code value = new Code();
		value.setCode(sugDTOs[i].getSd_incitp());
		value.setCodeSystem("2.16.156.10011.2.3.1.256");
		value.setCodeSystemName("手术切口类别代码表");
		value.setDisplayName(sugDTOs[i].getName_incitp());
		observation.setCvalue(value);;
		entryRelationshipInLvl.setObservation(observation);
	}
	
	/**
	 * 手术级别
	 * @param sugDTOs
	 * @param i
	 * @param entryRelationshipLvl
	 */
	private void getSugLvl(CiMrFpSugDTO[] sugDTOs, int i,
			EntryRelationship entryRelationshipLvl) {
		entryRelationshipLvl.setTypeCode("COMP");
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife cName = new CodeLife();
		cName.setCode("DE06.00.255.00");
		cName.setCodeSystem("2.16.156.10011.2.2.1");
		cName.setCodeSystemName("卫生信息数据元目录");
		cName.setDisplayName("手术级别");
		observation.setCode(cName);
		observation.setStrValue(sugDTOs[i].getName_lvlsug());
		entryRelationshipLvl.setObservation(observation);
	}
	
	/**
	 * 手术名
	 * @param sugDTOs
	 * @param i
	 * @param entryRelationshipName
	 */
	private void getSugName(CiMrFpSugDTO[] sugDTOs, int i,
			EntryRelationship entryRelationshipName) {
		entryRelationshipName.setTypeCode("COMP");
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife cName = new CodeLife();
		cName.setCode("DE06.00.094.00");
		cName.setCodeSystem("2.16.156.10011.2.2.1");
		cName.setCodeSystemName("卫生信息数据元目录");
		cName.setDisplayName("手术（操作）名称");
		observation.setCode(cName);
		observation.setStrValue(sugDTOs[i].getName_sug());
		entryRelationshipName.setObservation(observation);
	}

	/**
	 * 二助
	 * @param sugDTOs
	 * @param i
	 * @param participant1
	 */
	private void getSugAssistant2(CiMrFpSugDTO[] sugDTOs, int i,
			ParticipantAlg participant2) {
		participant2.setTypeCode("ATND");
		ParticipantRole participantRole = new ParticipantRole();
		participantRole.setClassCode("ASSIGNED");
		Identification id = new Identification();
		id.setRoot("2.16.156.10011.1.4");
		id.setExtension(sugDTOs[i].getSd_emp_asst2());
		participantRole.setId(id);
		Code code1 = new Code();
		code1.setDisplayName("第二助手");
		participantRole.setCode(code1);
		PlayingEntity playingEntity = new PlayingEntity();
		playingEntity.setClassCode("PSN");
		playingEntity.setDeterminerCode("INSTANCE");
		playingEntity.setName(sugDTOs[i].getName_emp_asst2());
		participantRole.setPlayingEntity(playingEntity);
		participant2.setParticipantRole(participantRole);
	}
	
	/**
	 * 一助
	 * @param sugDTOs
	 * @param i
	 * @param participant1
	 */
	private void getSugAssistant1(CiMrFpSugDTO[] sugDTOs, int i,
			ParticipantAlg participant1) {
		participant1.setTypeCode("ATND");
		ParticipantRole participantRole = new ParticipantRole();
		participantRole.setClassCode("ASSIGNED");
		Identification id = new Identification();
		id.setRoot("2.16.156.10011.1.4");
		id.setExtension(sugDTOs[i].getSd_emp_asst1());
		participantRole.setId(id);
		Code code1 = new Code();
		code1.setDisplayName("第一助手");
		participantRole.setCode(code1);
		PlayingEntity playingEntity = new PlayingEntity();
		playingEntity.setClassCode("PSN");
		playingEntity.setDeterminerCode("INSTANCE");
		playingEntity.setName(sugDTOs[i].getName_emp_asst1());
		participantRole.setPlayingEntity(playingEntity);
		participant1.setParticipantRole(participantRole);
	}

	/**
	 * 术者
	 * @param sugDTOs
	 * @param i
	 * @param assignedEntitys
	 */
	private void getSugPerformer(CiMrFpSugDTO[] sugDTOs, int i,
			List<AssignedAuthor> assignedEntitys) {
		AssignedAuthor assign = new AssignedAuthor();
		Identification id = new Identification();
		id.setRoot("2.16.156.10011.1.4");
		id.setExtension(sugDTOs[i].getSd_emp_sug());
		assign.setId(id);
		ProviderOrganization assignedPerson = new ProviderOrganization();
		assignedPerson.setName(sugDTOs[i].getName_emp_sug());
		assign.setAssignedPerson(assignedPerson);
		assignedEntitys.add(assign);
	}
	
	/**
	 * 住院史章节
	 * @return
	 */
	private List<SectionIHH> getSectionIHHs(CiMrFpDTO pat )
	{
		List<SectionIHH> sectionIHHs = new ArrayList<SectionIHH>();
		SectionIHH sectionIHH = new SectionIHH();
		Code code = new Code();
		code.setCode("11336-5");
		code.setDisplayName("HISTORY OF HOSPITALIZATIONS");
		code.setCodeSystem("2.16.840.1.113883.6.1");
		code.setCodeSystemName("LOINC");
		sectionIHH.setCode(code);
		EntryLife entryDays = new EntryLife();
		entryDays.setTypeCode("COMP");
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife codeTime = new CodeLife();
		codeTime.setCode("DE02.10.090.00");
		codeTime.setDisplayName("住院次数");
		codeTime.setCodeSystem("2.16.156.10011.2.2.1");
		codeTime.setCodeSystemName("卫生信息数据元目录");
		observation.setCode(codeTime);
		CValue value = new CValue();
		value.setUnit("次");
		if(pat.getN_times_inhospital()==null)
			value.setValue(null);
		else
			value.setValue(pat.getN_times_inhospital().toString());
		observation.setValue(value);
		entryDays.setObservation(observation);
		sectionIHH.setEntryDays(entryDays);
		sectionIHHs.add(sectionIHH);
		return sectionIHHs;
	}
	
	/**
	 * 住院过程章节 
	 * @return
	 */
	private List<SectionIHH> getSectionIHCs(CiMrFpDTO pat )
	{
		List<SectionIHH> sectionIHCs = new ArrayList<SectionIHH>();
		SectionIHH sectionIHC = new SectionIHH();
		Code code = new Code();
		code.setCode("8648-8");
		code.setDisplayName("Hospital Course");
		code.setCodeSystem("2.16.840.1.113883.6.1");
		code.setCodeSystemName("LOINC");
		sectionIHC.setCode(code);
		EntryLife entryDays = new EntryLife();
		entryDays.setTypeCode("COMP");
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife codeDays = new CodeLife();
		codeDays.setCode("DE06.00.310.00");
		codeDays.setCodeSystem("2.16.156.10011.2.2.1");
		codeDays.setCodeSystemName("卫生信息数据元目录");
		codeDays.setDisplayName("实际住院天数");
		observation.setCode(codeDays);
		CValue valueDays = new CValue();
		if(pat.getHosdays()==null)
			valueDays.setValue(null);
		else
			valueDays.setValue(pat.getHosdays().toString());
		valueDays.setUnit("天");
		observation.setValue(valueDays);
		entryDays.setObservation(observation);
		sectionIHC.setEntryDays(entryDays);
		//科室、病房
		EntryAlg entryDep = new EntryAlg();
		ActAlg act = new ActAlg();
		Author author = new Author();
		AssignedAuthor assignedAuthor = new AssignedAuthor();
		WholeOrganization representedOrganization = new WholeOrganization();
		Identification idWard = new Identification();
		idWard.setRoot("2.16.156.10011.1.21");
		idWard.setExtension(pat.getSd_out_bed());
		representedOrganization.setId(idWard);
		representedOrganization.setName(pat.getName_out_bed());
		AsOrganizationPartOf asOrganizationPartOf = new AsOrganizationPartOf();
		asOrganizationPartOf.setClassCode("PART");
		ProviderOrganization wholeOrganization = new ProviderOrganization();
		wholeOrganization.setClassCode("ORG");
		wholeOrganization.setDeterminerCode("INSTANCE");
		Identification idDep = new Identification();
		idDep.setRoot("2.16.156.10011.1.26");
		idDep.setExtension(pat.getSd_dep_phydisc());
		wholeOrganization.setId(idDep);
		asOrganizationPartOf.setWholeOrganization(wholeOrganization);
		representedOrganization.setAsOrganizationPartOf(asOrganizationPartOf);
		assignedAuthor.setRepresentedOrganization(representedOrganization);
		author.setAssignedAuthor(assignedAuthor);
		act.setAuthor(author);
		entryDep.setAct(act);
		sectionIHC.setEntryDep(entryDep);
		sectionIHCs.add(sectionIHC);
		
		return sectionIHCs;
	}
	
	/**
	 * 行政管理章节
	 * @return
	 */
	private List<SectionQu> getSectionQus(CiMrFpDTO pat)
	{
		List<SectionQu> sectionQus = new ArrayList<SectionQu>();
		SectionQu sectionQu = new SectionQu();
		Code code = new Code();
		code.setDisplayName("行政管理");
		sectionQu.setCode(code);
		EntryLife entryPaDe = new EntryLife();
		entryPaDe.setTypeCode("COMP");
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife codep = new CodeLife();
		codep.setCode("DE09.00.108.00");
		codep.setDisplayName("死亡患者尸检标志");
		codep.setCodeSystem("2.16.156.10011.2.2.1");
		codep.setCodeSystemName("卫生信息数据元目录");		
		observation.setCode(codep);
		CValue value = new CValue();
		value.setValue(pat.getName_aut_dead_pat());
		observation.setValue(value);
		entryPaDe.setObservation(observation);
		sectionQu.setEntryPaDe(entryPaDe);
		
		List<ObservationQu> observations = new ArrayList<ObservationQu>();
		ObservationQu observationQu = new ObservationQu();
		observationQu.setClassCode("OBS");
		observationQu.setMoodCode("EVN");
		Code codeQ = new Code();
		codeQ.setCode("DE09.00.103.00");
		codeQ.setDisplayName("病案质量");
		codeQ.setCodeSystem("2.16.156.10011.2.2.1");
		codeQ.setCodeSystemName("卫生信息数据元目录");
		observationQu.setCode(codeQ);
		CValue effectiveTime = new CValue();
		if(pat.getQc_date()==null)
			effectiveTime.setValue(null);
		else
			effectiveTime.setValue(pat.getQc_date().toLocalString());
		observationQu.setEffectiveTime(effectiveTime);
		Code cValue = new Code();
		cValue.setCode(pat.getName_qom_record());
		cValue.setDisplayName("");//确实name
		cValue.setCodeSystem("2.16.156.10011.2.3.2.29");
		cValue.setCodeSystemName("病案质量等级表");	
		observationQu.setCValue(cValue);
		Author authorD = getQcpDoc(pat);
		observationQu.setAuthorDoc(authorD);
		//assignedAuthor.set
		observations.add(observationQu);
		sectionQu.setObservation(observations);
		sectionQus.add(sectionQu);
		return sectionQus;
	}

	/**
	 * 质控医生
	 * @param pat
	 * @return
	 */
	private Author getQcpDoc(CiMrFpDTO pat) {
		Author authorD = new Author();
		AssignedAuthor assignedAuthor = new AssignedAuthor();
		Identification idD = new Identification();
		idD.setRoot("2.16.156.10011.1.4");
		idD.setExtension("");//缺少质控医生人员编码
		assignedAuthor.setId(idD);
		Code codeD = new Code();
		codeD.setDisplayName("质控医生");
		assignedAuthor.setCode(codeD);
		ProviderOrganization assignedPersonD = new ProviderOrganization();
		assignedPersonD.setName(pat.getName_qcp_doc());
		assignedAuthor.setAssignedPerson(assignedPersonD);
		return authorD;
	}
	/**
	 * 质控护士
	 * @param pat
	 * @return
	 */
	private Author getQcpNur(CiMrFpDTO pat) {
		Author authorD = new Author();
		AssignedAuthor assignedAuthor = new AssignedAuthor();
		Identification idD = new Identification();
		idD.setRoot("2.16.156.10011.1.4");
		idD.setExtension("");//缺少质控护士人员编码
		assignedAuthor.setId(idD);
		Code codeD = new Code();
		codeD.setDisplayName("质控护士");
		assignedAuthor.setCode(codeD);
		ProviderOrganization assignedPersonD = new ProviderOrganization();
		assignedPersonD.setName(pat.getName_qcp_nur());
		assignedAuthor.setAssignedPerson(assignedPersonD);
		return authorD;
	}
	
	/**
	 * 治疗计划章节
	 * @return
	 */
	private List<SectionCP> getSectionCPs(CiMrFpDTO pat)
	{
		List<SectionCP> sectionCPs = new ArrayList<SectionCP>();
		SectionCP sectionCP = new SectionCP();
		Code code = new Code();
		code.setCode("18776-5");
		code.setDisplayName("TREATMENT PLAN");
		code.setCodeSystem("2.16.840.1.113883.6.1");
		code.setCodeSystemName("LOINC");
		sectionCP.setCode(code);
		EntryHel entry = new EntryHel();
		ObservationHel observation =new  ObservationHel();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		Code codeP = new Code();
		codeP.setCode("DE06.00.194.00");
		codeP.setCodeSystem("2.16.156.10011.2.2.1");
		codeP.setCodeSystemName("卫生信息数据元目录");
		codeP.setDisplayName("出院31天内再住院标志");
		observation.setCode(codeP);
		CValue cvalue = new CValue();
		cvalue.setValue(pat.getName_is_have_inhos_plan());//name还是sd
		observation.setCValue(cvalue);
		List<EntryRelationship> entryRelationships = new ArrayList<EntryRelationship>();
		EntryRelationship entyRelationship = new EntryRelationship();
		entyRelationship.setTypeCode("GEVL");
		entyRelationship.setNegationInd("false");
		Observation observationP = new Observation();
		observationP.setClassCode("OBS");
		observationP.setMoodCode("EVN");
		CodeLife codePur = new CodeLife();
		codePur.setCode("DE06.00.195.00");
		codePur.setCodeSystem("2.16.156.10011.2.2.1");
		codePur.setCodeSystemName("卫生信息数据元目录");
		codePur.setDisplayName("出院31天内再住院目的");
		observationP.setCode(codePur);
		observationP.setStrValue(pat.getGoal_inhos_plan());
		entyRelationship.setObservation(observationP);
		entryRelationships.add(entyRelationship);
		observation.setEntyRelationship(entryRelationships);
		entry.setObservation(observation);
		sectionCP.setEntry(entry);
		sectionCPs.add(sectionCP);
		return sectionCPs;
	}
	
	/**
	 * 费用章节
	 * @return
	 */
	private List<SectionBL> getSectionBLs(CiMrFpDTO pat)
	{
		List<SectionBL> sectionBLs = new ArrayList<SectionBL>();
		SectionBL sectionBL =new  SectionBL();
		Code code = new Code();
		code.setCode("DE07.00.007.00");
		code.setCodeSystem("2.16.156.10011.2.2.1");
		code.setCodeSystemName("卫生信息数据元目录");
		code.setDisplayName("医疗付款方式代码");
		sectionBL.setCode(code);
		EntryLife entryType = getEntryType(pat);
		sectionBL.setEntryType(entryType);
		EntryHel entryTotal = getEntryTotalBl(pat);
		sectionBL.setEntryTotal(entryTotal);
		EntryHel2 entryZH = getEntryZHBl(pat);
		sectionBL.setEntryZH(entryZH);
		EntryHel2 entryDi = getEntryDiBl(pat);
		sectionBL.setEntryDi(entryDi);
		EntryHel2 entryCure = getEntryCureBl(pat);
		sectionBL.setEntryCure(entryCure);
		EntryLife entryKF = getEntryKFBl(pat);
		sectionBL.setEntryKF(entryKF);
		EntryLife entryUsecmp = getEntryUsecmp(pat);
		sectionBL.setEntryUsecmp(entryUsecmp);
		EntryLife entryUsecmdt = getEntryUsecmt(pat);
		sectionBL.setEntryUsecmdt(entryUsecmdt);
		EntryLife entryDnur = getEntryDnur(pat);
		sectionBL.setEntryDnur(entryDnur);
		
		EntryHel2 entryCureCn = getEntryCureCnBl(pat);		
		sectionBL.setEntryCureCn(entryCureCn);		
		EntryHel entryMed = getEntryMedBl(pat);
		sectionBL.setEntryMed(entryMed);
		EntryHel2 entryMedCn = getEntryMedCnBl(pat);	
		sectionBL.setEntryMedCn(entryMedCn);
		EntryHel2 entryBlood = getEntryBloodBl(pat);	
		sectionBL.setEntryBlood(entryBlood);
		EntryLife entryUsecme = getEntryUsecme(pat);
		sectionBL.setEntryUsecme(entryUsecme);
		EntryHel2 entryHC = getEntryHCBl(pat);	
		sectionBL.setEntryHC(entryHC);
		EntryLife entryOhr = getEntryOhrBl(pat);
		sectionBL.setEntryOhr(entryOhr);
		sectionBLs.add(sectionBL);
		return sectionBLs;
	}
	
	/**
	 * 辩证施护标志
	 * @param pat
	 * @return
	 */
	private EntryLife getEntryDnur(CiMrFpDTO pat) {
		EntryLife entryType = new EntryLife();
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife codeType = new CodeLife();
		codeType.setCode("DE06.00.180.00");
		codeType.setCodeSystem("2.16.156.10011.2.2.1");
		codeType.setCodeSystemName("卫生信息数据元目录");
		codeType.setDisplayName("辩证施护标志");
		observation.setCode(codeType);
		CValue value = new CValue();
		if(pat.getId_dnur()!=null)
			if(pat.getId_dnur()=="1")
				value.setValue("true");
			else {
				value.setValue("false");
			}
		else {
			value.setValue("");
		}
		observation.setValue(value);
		entryType.setObservation(observation);
		return entryType;
	}
	
	/**
	 * 使用中医诊疗技术标志
	 * @param pat
	 * @return
	 */
	private EntryLife getEntryUsecmt(CiMrFpDTO pat) {
		EntryLife entryType = new EntryLife();
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife codeType = new CodeLife();
		codeType.setCode("DE06.00.245.00");
		codeType.setCodeSystem("2.16.156.10011.2.2.1");
		codeType.setCodeSystemName("卫生信息数据元目录");
		codeType.setDisplayName("使用中医诊疗技术标志");
		observation.setCode(codeType);
		CValue value = new CValue();
		if(pat.getId_usecmdt()!=null)
			if(pat.getId_usecmdt()=="1")
				value.setValue("true");
			else {
				value.setValue("false");
			}
		else {
			value.setValue("");
		}
		observation.setValue(value);
		entryType.setObservation(observation);
		return entryType;
	}
	/**
	 * 使用医疗机构中药制剂标志
	 * @param pat
	 * @return
	 */
	private EntryLife getEntryUsecmp(CiMrFpDTO pat) {
		EntryLife entryType = new EntryLife();
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife codeType = new CodeLife();
		codeType.setCode("DE06.00.243.00");
		codeType.setCodeSystem("2.16.156.10011.2.2.1");
		codeType.setCodeSystemName("卫生信息数据元目录");
		codeType.setDisplayName("使用医疗机构中药制剂");
		observation.setCode(codeType);
		CValue value = new CValue();
		if(pat.getId_usecmp()!=null)
			if(pat.getId_usecmp()=="1")
				value.setValue("true");
			else {
				value.setValue("false");
			}
		else {
			value.setValue("");
		}
		observation.setValue(value);
		entryType.setObservation(observation);
		return entryType;
	}
	/**
	 * 使用中医诊疗设备标志
	 * @param pat
	 * @return
	 */
	private EntryLife getEntryUsecme(CiMrFpDTO pat) {
		EntryLife entryType = new EntryLife();
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife codeType = new CodeLife();
		codeType.setCode("DE06.00.244.00");
		codeType.setCodeSystem("2.16.156.10011.2.2.1");
		codeType.setCodeSystemName("卫生信息数据元目录");
		codeType.setDisplayName("使用中医诊疗设备标志");
		observation.setCode(codeType);
		CValue value = new CValue();
		if(pat.getId_usecme()!=null)
			if(pat.getId_usecme()=="1")
				value.setValue("true");
			else {
				value.setValue("false");
			}
		else {
			value.setValue("");
		}
		observation.setValue(value);
		entryType.setObservation(observation);
		return entryType;
	}
	
	/**
	 * 其他费
	 * @param pat
	 * @return
	 */
	private EntryLife getEntryOhrBl(CiMrFpDTO pat) {
		EntryLife entryType = new EntryLife();
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife codeType = new CodeLife();
		codeType.setCode("HDSD00.12.092");
		codeType.setCodeSystem("2.16.156.10011.2.2.4");
		codeType.setCodeSystemName("卫生信息数据元目录");
		codeType.setDisplayName("其他费");
		observation.setCode(codeType);
		CValue value = new CValue();
		if(pat.getOc_ocfee()!=null)
			value.setValue(pat.getOc_ocfee().toString());
		else {
			value.setValue("");
		}
		value.setCurrentcy("元");
		observation.setValue(value);
		entryType.setObservation(observation);
		return entryType;
	}
	
	/**
	 * 耗材类费用
	 * @param pat
	 * @return
	 */
	private EntryHel2 getEntryHCBl(CiMrFpDTO pat) {
		EntryHel2 entryDi = new EntryHel2();
		OrganizerDi organizer = new OrganizerDi();
		organizer.setClassCode("CLUSTER");
		organizer.setMoodCode("EVN");
		List<ComponentSon> components = new ArrayList<ComponentSon>();
		ComponentSon componentSon1 = new ComponentSon();
		ObservationHel observation1 = new ObservationHel();
		observation1.setClassCode("OBS");
		observation1.setMoodCode("EVN");
		CodeLife code1 = new CodeLife();
		code1.setCode("HDSD00.12.045");
		code1.setCodeSystem("2.16.156.10011.2.2.4");
		code1.setCodeSystemName("住院病案首页基本数据集");
		code1.setDisplayName("一次性医用材料费-检查用");
		observation1.setCode(code1);
		CValue value1 = new CValue();
		if(pat.getSc_dmmfifee()==null)
			value1.setValue("");
		else
			value1.setValue(pat.getSc_dmmfifee().toString());
		value1.setCurrentcy("元");
		observation1.setCValue(value1);
		componentSon1.setObservation(observation1);
		components.add(componentSon1);
		
		ComponentSon componentSon2 = new ComponentSon();
		ObservationHel observation2 = new ObservationHel();
		observation2.setClassCode("OBS");
		observation2.setMoodCode("EVN");		
		CodeLife code2 = new CodeLife();
		code2.setCode("HDSD00.12.047");
		code2.setCodeSystem("2.16.156.10011.2.2.4");
		code2.setCodeSystemName("住院病案首页基本数据集");
		code2.setDisplayName("一次性医用材料费-治疗用");
		observation2.setCode(code2);
		CValue value2 = new CValue(); 
		if(pat.getSc_dmmftfee()==null)
			value2.setValue("");
		else
			value2.setValue(pat.getSc_dmmftfee().toString());
		value2.setCurrentcy("元");
		observation2.setCValue(value2);
		componentSon2.setObservation(observation2);
		components.add(componentSon2);
		
		ComponentSon componentSon3 = new ComponentSon();
		ObservationHel observation3 = new ObservationHel();
		observation3.setClassCode("OBS");
		observation3.setMoodCode("EVN");		
		CodeLife code3 = new CodeLife();
		code3.setCode("HDSD00.12.046");
		code3.setCodeSystem("2.16.156.10011.2.2.4");
		code3.setCodeSystemName("住院病案首页基本数据集");
		code3.setDisplayName("一次性医用材料费-手术用");
		observation3.setCode(code3);
		CValue value3 = new CValue();
		if(pat.getSc_dmmfsfee()==null)
			value3.setValue("");
		else
			value3.setValue(pat.getSc_dmmfsfee().toString());
		value3.setCurrentcy("元");
		observation3.setCValue(value3);
		componentSon3.setObservation(observation3);
		components.add(componentSon3);		
		organizer.setComponent(components);
		entryDi.setOrganizer(organizer);
		return entryDi;
	}
	
	/**
	 * 血液和血液制品类服务费
	 * @param pat
	 * @return
	 */
	private EntryHel2 getEntryBloodBl(CiMrFpDTO pat) {
		EntryHel2 entryDi = new EntryHel2();
		OrganizerDi organizer = new OrganizerDi();
		organizer.setClassCode("CLUSTER");
		organizer.setMoodCode("EVN");
		List<ComponentSon> components = new ArrayList<ComponentSon>();
		ComponentSon componentSon1 = new ComponentSon();
		ObservationHel observation1 = new ObservationHel();
		observation1.setClassCode("OBS");
		observation1.setMoodCode("EVN");
		CodeLife code1 = new CodeLife();
		code1.setCode("HDSD00.12.130");
		code1.setCodeSystem("2.16.156.10011.2.2.4");
		code1.setCodeSystemName("住院病案首页基本数据集");
		code1.setDisplayName("血费");
		observation1.setCode(code1);
		CValue value1 = new CValue();
		if(pat.getBabp_bfee()==null)
			value1.setValue("");
		else
			value1.setValue(pat.getBabp_bfee().toString());
		value1.setCurrentcy("元");
		observation1.setCValue(value1);
		componentSon1.setObservation(observation1);
		components.add(componentSon1);
		
		ComponentSon componentSon2 = new ComponentSon();
		ObservationHel observation2 = new ObservationHel();
		observation2.setClassCode("OBS");
		observation2.setMoodCode("EVN");
		CodeLife code2 = new CodeLife();
		code2.setCode("HDSD00.12.126");
		code2.setCodeSystem("2.16.156.10011.2.2.4");
		code2.setCodeSystemName("住院病案首页基本数据集");
		code2.setDisplayName("白蛋白类制品费");
		observation2.setCode(code2);
		CValue value2 = new CValue(); 
		if(pat.getBabp_apfee()==null)
			value2.setValue("");
		else
			value2.setValue(pat.getBabp_apfee().toString());
		value2.setCurrentcy("元");
		observation2.setCValue(value2);
		componentSon2.setObservation(observation2);
		components.add(componentSon2);
		
		ComponentSon componentSon3 = new ComponentSon();
		ObservationHel observation3 = new ObservationHel();
		observation3.setClassCode("OBS");
		observation3.setMoodCode("EVN");
		CodeLife code3 = new CodeLife();
		code3.setCode("HDSD00.12.128");
		code3.setCodeSystem("2.16.156.10011.2.2.4");
		code3.setCodeSystemName("住院病案首页基本数据集");
		code3.setDisplayName("球蛋白类制品费");
		observation3.setCode(code3);
		CValue value3 = new CValue();
		if(pat.getBabp_gpfee()==null)
			value3.setValue(null);
		else
			value3.setValue(pat.getBabp_gpfee().toString());
		value3.setCurrentcy("元");
		observation3.setCValue(value3);
		componentSon3.setObservation(observation3);
		components.add(componentSon3);
		
		ComponentSon componentSon4 = new ComponentSon();
		ObservationHel observation4 = new ObservationHel();
		observation4.setClassCode("OBS");
		observation4.setMoodCode("EVN");
		CodeLife code4 = new CodeLife();
		code4.setCode("HDSD00.12.127");
		code4.setCodeSystem("2.16.156.10011.2.2.4");
		code4.setCodeSystemName("住院病案首页基本数据集");
		code4.setDisplayName("凝血因子类制品费");
		observation4.setCode(code4);
		CValue value4 = new CValue(); 
		if(pat.getBabp_bcffee()==null)
			value4.setValue(null);
		else
			value4.setValue(pat.getBabp_bcffee().toString());
		value4.setCurrentcy("元");
		observation4.setCValue(value4);
		componentSon4.setObservation(observation4);
		components.add(componentSon4);
		
		ComponentSon componentSon5 = new ComponentSon();
		ObservationHel observation5 = new ObservationHel();
		observation5.setClassCode("OBS");
		observation5.setMoodCode("EVN");
		CodeLife code5 = new CodeLife();
		code5.setCode("HDSD00.12.129");
		code5.setCodeSystem("2.16.156.10011.2.2.4");
		code5.setCodeSystemName("住院病案首页基本数据集");
		code5.setDisplayName("细胞因子类制品费");
		observation5.setCode(code5);
		CValue value5 = new CValue(); 
		if(pat.getBabp_cflfee()==null)
			value5.setValue(null);
		else
			value5.setValue(pat.getBabp_cflfee().toString());
		value5.setCurrentcy("元");
		observation5.setCValue(value5);
		componentSon5.setObservation(observation5);
		components.add(componentSon5);
		
		organizer.setComponent(components);
		entryDi.setOrganizer(organizer);
		return entryDi;
	}
	
	/**
	 * 中药费
	 * @param pat
	 * @return
	 */
	private EntryHel2 getEntryMedCnBl(CiMrFpDTO pat) {
		EntryHel2 entryDi = new EntryHel2();
		OrganizerDi organizer = new OrganizerDi();
		organizer.setClassCode("CLUSTER");
		organizer.setMoodCode("EVN");
		List<ComponentSon> components = new ArrayList<ComponentSon>();
		ComponentSon componentSon1 = new ComponentSon();
		ObservationHel observation1 = new ObservationHel();
		observation1.setClassCode("OBS");
		observation1.setMoodCode("EVN");
		CodeLife code1 = new CodeLife();
		code1.setCode("HDSD00.12.151");
		code1.setCodeSystem("2.16.156.10011.2.2.4");
		code1.setCodeSystemName("住院病案首页基本数据集");
		code1.setDisplayName("中药费-中成药费");
		observation1.setCode(code1);
		CValue value1 = new CValue();
		if(pat.getTcmt_cpmfee()==null)
			value1.setValue("0");
		else
			value1.setValue(pat.getTcmt_cpmfee().toString());
		value1.setCurrentcy("元");
		observation1.setCValue(value1);
		componentSon1.setObservation(observation1);
		components.add(componentSon1);
		
		ComponentSon componentSon2 = new ComponentSon();
		ObservationHel observation2 = new ObservationHel();
		observation2.setClassCode("OBS");
		observation2.setMoodCode("EVN");
		
		CodeLife code2 = new CodeLife();
		code2.setCode("HDSD00.12.152");
		code2.setCodeSystem("2.16.156.10011.2.2.4");
		code2.setCodeSystemName("住院病案首页基本数据集");
		code2.setDisplayName("中药类-中成药费-医疗机构中药制剂费");
		observation2.setCode(code2);
		CValue value2 = new CValue(); 
		if(pat.getTcmt_ppafee()==null)
			value2.setValue("");
		else
			value2.setValue(pat.getTcmt_ppafee().toString());
		value2.setCurrentcy("元");
		observation2.setCValue(value2);
		componentSon2.setObservation(observation2);
		components.add(componentSon2);
		
		ComponentSon componentSon3 = new ComponentSon();
		ObservationHel observation3 = new ObservationHel();
		observation3.setClassCode("OBS");
		observation3.setMoodCode("EVN");		
		CodeLife code3 = new CodeLife();
		code3.setCode("HDSD00.12.150");
		code3.setCodeSystem("2.16.156.10011.2.2.4");
		code3.setCodeSystemName("住院病案首页基本数据集");
		code3.setDisplayName("中药费-中草药费");
		observation3.setCode(code3);
		CValue value3 = new CValue();
		if(pat.getTcmt_chmfee()==null)
			value3.setValue("");
		else
			value3.setValue(pat.getTcmt_chmfee().toString());
		value3.setCurrentcy("元");
		observation3.setCValue(value3);
		componentSon3.setObservation(observation3);
		components.add(componentSon3);
		
		organizer.setComponent(components);
		entryDi.setOrganizer(organizer);
		return entryDi;
	}
	
	/**
	 * 西药费用
	 * @param pat
	 * @return
	 */
	private EntryHel getEntryMedBl(CiMrFpDTO pat) {
		EntryHel entryTotal = new EntryHel();
		ObservationHel observation = new ObservationHel();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		Code codeTotal = new Code();
		codeTotal.setCode("HDSD00.12.113");
		codeTotal.setCodeSystem("2.16.156.10011.2.2.4");
		codeTotal.setCodeSystemName("住院病案首页基本数据集");
		codeTotal.setDisplayName("西药费");
		observation.setCode(codeTotal);
		CValue cvalue = new CValue();
		if(pat.getAmount()==null)
			cvalue.setValue(null);
		else
			cvalue.setValue(pat.getWm_wmfee().toString());
		cvalue.setCurrentcy("元");
		observation.setCValue(cvalue);
		List<EntryRelationship> entyRelationships = new ArrayList<EntryRelationship>();
		EntryRelationship entyRelationship = new EntryRelationship();
		entyRelationship.setTypeCode("COMP");
		Observation observationTotal = new Observation();
		observationTotal.setClassCode("OBS");
		observationTotal.setMoodCode("EVN");
		CodeLife codeTotalBl = new CodeLife();
		codeTotalBl.setCode("HDSD00.12.114");
		codeTotalBl.setCodeSystem("2.16.156.10011.2.2.4");
		codeTotalBl.setCodeSystemName("住院病案首页基本数据集");
		codeTotalBl.setDisplayName("西药费-抗菌药物费用");
		observationTotal.setCode(codeTotalBl);
		CValue value = new CValue();
		if(pat.getCms_spamount()==null)
			value.setValue("0");
		else
			value.setValue(pat.getWm_agfee().toString());
		value.setCurrentcy("元");
		observationTotal.setValue(value);
		entyRelationship.setObservation(observationTotal);
		entyRelationships.add(entyRelationship);
		observation.setEntyRelationship(entyRelationships);
		entryTotal.setObservation(observation);
		return entryTotal;
	}
	
	/**
	 * 中医类费用（中医和民族医医疗服务）
	 * @param pat
	 * @return
	 */
	private EntryHel2 getEntryCureCnBl(CiMrFpDTO pat) {
		EntryHel2 entryCureCn = new EntryHel2();
		OrganizerDi organizer = new OrganizerDi();
		organizer.setClassCode("CLUSTER");
		organizer.setMoodCode("EVN");
		List<ComponentSon> components = new ArrayList<ComponentSon>();		
		ComponentSon comDifee = new ComponentSon();//中医诊断费		
		ObservationHel obsDifee = new ObservationHel();
		obsDifee.setClassCode("OBS");
		obsDifee.setMoodCode("EVN");
		Code codeDifee = new Code();
		codeDifee.setCode("HDSD00.12.156");
		codeDifee.setCodeSystem("2.16.156.10011.2.2.4");
		codeDifee.setCodeSystemName("住院病案首页基本数据集");
		codeDifee.setDisplayName("中医诊断费");
		obsDifee.setCode(codeDifee);
		CValue valueDifee =new CValue();
		if(pat.getTcm_difee()!= null)
			valueDifee.setValue(pat.getTcm_difee().toString());
		else {
			valueDifee.setValue("0");
		}
		valueDifee.setCurrentcy("元");
		obsDifee.setCValue(valueDifee);
		comDifee.setObservation(obsDifee);
		components.add(comDifee);		
		ComponentSon comCmtfee = new ComponentSon();//中医治疗费	
		ObservationHel obsCmtfee = new ObservationHel();
		obsCmtfee.setClassCode("OBS");
		obsCmtfee.setMoodCode("EVN");
		Code codeCmtfee = new Code();
		codeCmtfee.setCode("HDSD00.12.157");
		codeCmtfee.setCodeSystem("2.16.156.10011.2.2.4");
		codeCmtfee.setCodeSystemName("住院病案首页基本数据集");
		codeCmtfee.setDisplayName("中医治疗费");
		obsCmtfee.setCode(codeCmtfee);
		CValue value_Cmtfee = new CValue();
		if(pat.getTcm_cmtfee()!=null)
			value_Cmtfee.setValue(pat.getTcm_cmtfee().toString());
		else {
			value_Cmtfee.setValue("0");
		}
		value_Cmtfee.setCurrentcy("元");
		obsCmtfee.setCValue(value_Cmtfee);
		List<EntryRelationship> entyRelationships = new ArrayList<EntryRelationship>();		
		EntryRelationship comEtfee = new EntryRelationship();//中医治疗费-中医外治
		comEtfee.setTypeCode("COMP");
		Observation obsEtfee = new Observation();
		obsEtfee.setClassCode("OBS");
		obsEtfee.setMoodCode("EVN");
		CodeLife codeEtfee = new CodeLife();
		codeEtfee.setCode("HDSD00.12.163");
		codeEtfee.setCodeSystem("2.16.156.10011.2.2.4");
		codeEtfee.setCodeSystemName("住院病案首页基本数据集");
		codeEtfee.setDisplayName("中医类-中医治疗费-中医外治");
		obsEtfee.setCode(codeEtfee);
		CValue valueEtfee = new CValue();
		if(pat.getTcm_etfee()!=null)
			valueEtfee.setValue(pat.getTcm_etfee().toString());
		else {
			valueEtfee.setValue("0");
		}
		valueEtfee.setCurrentcy("元");
		obsEtfee.setValue(valueEtfee);
		comEtfee.setObservation(obsEtfee);
		entyRelationships.add(comEtfee);		
		EntryRelationship comBffee = new EntryRelationship();//中医治疗费-中医骨伤
		comBffee.setTypeCode("COMP");
		Observation obsBffee = new Observation();
		obsBffee.setClassCode("OBS");
		obsBffee.setMoodCode("EVN");
		CodeLife codeBffee = new CodeLife();
		codeBffee.setCode("HDSD00.12.160");
		codeBffee.setCodeSystem("2.16.156.10011.2.2.4");
		codeBffee.setCodeSystemName("住院病案首页基本数据集");
		codeBffee.setDisplayName("中医类-中医治疗费-中医骨伤");
		obsBffee.setCode(codeBffee);
		CValue valueBffee = new CValue();
		if(pat.getTcm_bffee()!=null)
			valueBffee.setValue(pat.getTcm_bffee().toString());
		else {
			valueBffee.setValue("0");
		}
		valueBffee.setCurrentcy("元");
		obsBffee.setValue(valueBffee);
		comBffee.setObservation(obsBffee);
		entyRelationships.add(comBffee);		
		EntryRelationship comTcmfee = new EntryRelationship();//中医治疗费-针刺与灸法
		comTcmfee.setTypeCode("COMP");
		Observation obsTcmfee = new Observation();
		obsTcmfee.setClassCode("OBS");
		obsTcmfee.setMoodCode("EVN");
		CodeLife codeTcmfee = new CodeLife();
		codeTcmfee.setCode("HDSD00.12.158");
		codeTcmfee.setCodeSystem("2.16.156.10011.2.2.4");
		codeTcmfee.setCodeSystemName("住院病案首页基本数据集");
		codeTcmfee.setDisplayName("中医类-中医治疗费-中医骨伤");
		obsTcmfee.setCode(codeTcmfee);
		CValue valueTcmfee= new CValue();
		if(pat.getTcm_tcmfee()!=null)
			valueTcmfee.setValue(pat.getTcm_tcmfee().toString());
		else {
			valueTcmfee.setValue("0");
		}
		valueTcmfee.setCurrentcy("元");
		obsTcmfee.setValue(valueTcmfee);
		comTcmfee.setObservation(obsTcmfee);
		entyRelationships.add(comTcmfee);		
		EntryRelationship comMnpfee = new EntryRelationship();//中医治疗费-中医推拿治疗
		comMnpfee.setTypeCode("COMP");
		Observation obsMnpfee = new Observation();
		obsMnpfee.setClassCode("OBS");
		obsMnpfee.setMoodCode("EVN");
		CodeLife codeMnpfee = new CodeLife();
		codeMnpfee.setCode("HDSD00.12.162");
		codeMnpfee.setCodeSystem("2.16.156.10011.2.2.4");
		codeMnpfee.setCodeSystemName("住院病案首页基本数据集");
		codeMnpfee.setDisplayName("中医类-中医治疗费-中医推拿治疗");
		obsMnpfee.setCode(codeMnpfee);
		CValue valueMnpfee= new CValue();
		if(pat.getTcm_mnpfee()!=null)
			valueMnpfee.setValue(pat.getTcm_mnpfee().toString());
		else {
			valueMnpfee.setValue("0");
		}
		valueMnpfee.setCurrentcy("元");
		obsMnpfee.setValue(valueMnpfee);
		comMnpfee.setObservation(obsMnpfee);
		entyRelationships.add(comMnpfee);
		
		EntryRelationship comAnrfee = new EntryRelationship();//中医治疗费-中医肛肠治疗
		comAnrfee.setTypeCode("COMP");
		Observation obsAnrfee = new Observation();
		obsAnrfee.setClassCode("OBS");
		obsAnrfee.setMoodCode("EVN");
		CodeLife codeAnrfee = new CodeLife();
		codeAnrfee.setCode("HDSD00.12.162");
		codeAnrfee.setCodeSystem("2.16.156.10011.2.2.4");
		codeAnrfee.setCodeSystemName("住院病案首页基本数据集");
		codeAnrfee.setDisplayName("中医类-中医治疗费-中医肛肠治疗");
		obsAnrfee.setCode(codeAnrfee);
		CValue valueAnrfee= new CValue();
		if(pat.getTcm_anrfee()!=null)
			valueAnrfee.setValue(pat.getTcm_anrfee().toString());
		else {
			valueAnrfee.setValue("0");
		}
		valueAnrfee.setCurrentcy("元");
		obsAnrfee.setValue(valueAnrfee);
		comAnrfee.setObservation(obsAnrfee);
		entyRelationships.add(comAnrfee);		
		EntryRelationship comSpcialfee = new EntryRelationship();//中医治疗费-中医特殊治疗
		comSpcialfee.setTypeCode("COMP");
		Observation obsSpcialfee = new Observation();
		obsSpcialfee.setClassCode("OBS");
		obsSpcialfee.setMoodCode("EVN");
		CodeLife codeSpcialfee = new CodeLife();
		codeSpcialfee.setCode("HDSD00.12.162");
		codeSpcialfee.setCodeSystem("2.16.156.10011.2.2.4");
		codeSpcialfee.setCodeSystemName("住院病案首页基本数据集");
		codeSpcialfee.setDisplayName("中医类-中医治疗费-中医肛肠治疗");
		obsSpcialfee.setCode(codeSpcialfee);
		CValue valueSpcialfee= new CValue();
		if(pat.getTcm_spcialfee()!=null)
			valueSpcialfee.setValue(pat.getTcm_spcialfee().toString());
		else {
			valueSpcialfee.setValue("0");
		}
		valueSpcialfee.setCurrentcy("元");
		obsSpcialfee.setValue(valueSpcialfee);
		comSpcialfee.setObservation(obsSpcialfee);
		entyRelationships.add(comSpcialfee);
		
		obsCmtfee.setEntyRelationship(entyRelationships);
		comCmtfee.setObservation(obsCmtfee);
		components.add(comCmtfee);
		
		ComponentSon comOtherfee = new ComponentSon();//中医其他治疗费
		ObservationHel obsOtherfee = new ObservationHel();
		obsOtherfee.setClassCode("OBS");
		obsOtherfee.setMoodCode("EVN");
		Code codeOtherfee = new Code();
		codeOtherfee.setCode("HDSD00.12.153");
		codeOtherfee.setCodeSystem("2.16.156.10011.2.2.4");
		codeOtherfee.setCodeSystemName("住院病案首页基本数据集");
		codeOtherfee.setDisplayName("中医其他治疗费");
		obsOtherfee.setCode(codeOtherfee);
		CValue valueOther = new CValue();
		if(pat.getTcm_otherfee()!=null)
			valueOther.setValue(pat.getTcm_otherfee().toString());
		else {
			valueOther.setValue("0");
		}
		obsOtherfee.setCValue(valueOther);
		List<EntryRelationship> entyRelationships_other = new ArrayList<EntryRelationship>();		
		EntryRelationship enAllocationfee = new EntryRelationship();//中医其他费-中药特殊调配加工
		enAllocationfee.setTypeCode("COMP");
		Observation obsAllocationfee = new Observation();
		obsAllocationfee.setClassCode("OBS");
		obsAllocationfee.setMoodCode("EVN");
		CodeLife codeAllocationfee = new CodeLife();
		codeAllocationfee.setCode("HDSD00.12.162");
		codeAllocationfee.setCodeSystem("2.16.156.10011.2.2.4");
		codeAllocationfee.setCodeSystemName("住院病案首页基本数据集");
		codeAllocationfee.setDisplayName("中医类-中医治疗费-中医肛肠治疗");
		obsAllocationfee.setCode(codeAllocationfee);
		CValue valueAllocationfee= new CValue();
		if(pat.getTcm_allocationfee()!=null)
			valueAllocationfee.setValue(pat.getTcm_allocationfee().toString());
		else {
			valueAllocationfee.setValue("0");
		}
		valueAllocationfee.setCurrentcy("元");
		obsAllocationfee.setValue(valueAllocationfee);
		enAllocationfee.setObservation(obsAllocationfee);
		entyRelationships_other.add(enAllocationfee);		
		EntryRelationship enDcfee = new EntryRelationship();//中医治疗费-辩证施膳
		enDcfee.setTypeCode("COMP");
		Observation obsDcfee = new Observation();
		obsDcfee.setClassCode("OBS");
		obsDcfee.setMoodCode("EVN");
		CodeLife codeDcfee = new CodeLife();
		codeDcfee.setCode("HDSD00.12.162");
		codeDcfee.setCodeSystem("2.16.156.10011.2.2.4");
		codeDcfee.setCodeSystemName("住院病案首页基本数据集");
		codeDcfee.setDisplayName("中医类-中医治疗费-中医肛肠治疗");
		obsDcfee.setCode(codeDcfee);
		CValue valueDcfee= new CValue();
		if(pat.getTcm_dcfee()!=null)
			valueDcfee.setValue(pat.getTcm_dcfee().toString());
		else {
			valueDcfee.setValue("0");
		}
		valueDcfee.setCurrentcy("元");
		obsDcfee.setValue(valueDcfee);
		enDcfee.setObservation(obsDcfee);
		entyRelationships_other.add(enDcfee);	
		obsOtherfee.setEntyRelationship(entyRelationships_other);
		comOtherfee.setObservation(obsOtherfee);
		components.add(comOtherfee);
		organizer.setComponent(components);
	
		entryCureCn.setOrganizer(organizer);
		return entryCureCn;
	}
	
	/**
	 * 康复费类服务费
	 * @param pat
	 * @return
	 */
	private EntryLife getEntryKFBl(CiMrFpDTO pat) {
		EntryLife entryKF = new EntryLife();
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife codeKF = new CodeLife(); 
		codeKF.setCode("HDSD00.12.062");
		codeKF.setCodeSystem("2.16.156.10011.2.2.4");
		codeKF.setCodeSystemName("住院病案首页基本数据集");
		codeKF.setDisplayName("康复费");
		observation.setCode(codeKF);
		CValue value = new CValue();
		if(pat.getRc_rcfee()==null)
			value.setValue(null);
		else
			value.setValue(pat.getRc_rcfee().toString());
		value.setCurrentcy("元");
		observation.setValue(value);
		entryKF.setObservation(observation);
		return entryKF;
	}

	/**
	 * 治疗类服务费
	 * @param pat
	 * @return
	 */
	private EntryHel2 getEntryCureBl(CiMrFpDTO pat) {
		EntryHel2 entryDi = new EntryHel2();
		OrganizerDi organizer = new OrganizerDi();
		organizer.setClassCode("CLUSTER");
		organizer.setMoodCode("EVN");
		List<ComponentSon> components = new ArrayList<ComponentSon>();
		ComponentSon componentSon1 = new ComponentSon();
		ObservationHel observation1 = new ObservationHel();
		CodeLife code1 = new CodeLife();
		code1.setCode("HDSD00.12.145");
		code1.setCodeSystem("2.16.156.10011.2.2.4");
		code1.setCodeSystemName("住院病案首页基本数据集");
		code1.setDisplayName("治疗-非手术治疗项目费");
		observation1.setCode(code1);
		CValue value1 = new CValue(); 
		if(pat.getTc_nstpfee()==null)
			value1.setValue(null);
		else
			value1.setValue(pat.getTc_nstpfee().toString());
		value1.setCurrentcy("元");
		observation1.setCValue(value1);
		List<EntryRelationship> entyRelationships1 = new ArrayList<EntryRelationship>();
		EntryRelationship entyRelationship1 = new EntryRelationship();
		entyRelationship1.setTypeCode("COMP");
		Observation observationSon1 =new Observation();
		observationSon1.setClassCode("OBS");
		observationSon1.setMoodCode("EVN");
		CodeLife codeSon1 = new CodeLife();
		codeSon1.setCode("HDSD00.12.146");
		codeSon1.setCodeSystem("2.16.156.10011.2.2.4");
		codeSon1.setCodeSystemName("住院病案首页基本数据集");
		codeSon1.setDisplayName("治疗-非手术治疗项目费-临床物理治疗费");
		observationSon1.setCode(codeSon1);
		CValue valueSon1 = new CValue();
		if(pat.getTc_cptfee()==null)
			valueSon1.setValue(null);
		else
			valueSon1.setValue(pat.getTc_cptfee().toString());
		observationSon1.setValue(valueSon1);
		entyRelationship1.setObservation(observationSon1);		
		entyRelationships1.add(entyRelationship1);
		observation1.setEntyRelationship(entyRelationships1);
		componentSon1.setObservation(observation1);
		components.add(componentSon1);
		
		ComponentSon componentSon2 = new ComponentSon();
		ObservationHel observation2 = new ObservationHel();
		CodeLife code2 = new CodeLife();
		code2.setCode("HDSD00.12.147");
		code2.setCodeSystem("2.16.156.10011.2.2.4");
		code2.setCodeSystemName("住院病案首页基本数据集");
		code2.setDisplayName("治疗-手术治疗费");
		observation2.setCode(code2);
		CValue value2 = new CValue(); 
		if(pat.getTc_stfee()==null)
			value2.setValue(null);
		else
			value2.setValue(pat.getTc_stfee().toString());
		value2.setCurrentcy("元");
		observation2.setCValue(value2);
		List<EntryRelationship> entyRelationships = new ArrayList<EntryRelationship>();
		
		EntryRelationship entyRelationship2 = new EntryRelationship();
		entyRelationship2.setTypeCode("COMP");
		Observation observationSon2 =new Observation();
		observationSon2.setClassCode("OBS");
		observationSon2.setMoodCode("EVN");
		CodeLife codeSon2 = new CodeLife();
		codeSon2.setCode("HDSD00.12.148");
		codeSon2.setCodeSystem("2.16.156.10011.2.2.4");
		codeSon2.setCodeSystemName("住院病案首页基本数据集");
		codeSon2.setDisplayName("治疗-手术治疗费-麻醉费");
		observationSon2.setCode(codeSon2);
		CValue valueSon2 = new CValue();
		if(pat.getTc_anfee()==null)
			valueSon2.setValue(null);
		else
			valueSon2.setValue(pat.getTc_anfee().toString());
		observationSon2.setValue(valueSon2);
		entyRelationship2.setObservation(observationSon2);	
		entyRelationships.add(entyRelationship2);
		
		EntryRelationship entyRelationship3 = new EntryRelationship();
		entyRelationship3.setTypeCode("COMP");
		Observation observationSon3 =new Observation();
		observationSon3.setClassCode("OBS");
		observationSon3.setMoodCode("EVN");
		CodeLife codeSon3 = new CodeLife();
		codeSon3.setCode("HDSD00.12.149");
		codeSon3.setCodeSystem("2.16.156.10011.2.2.4");
		codeSon3.setCodeSystemName("住院病案首页基本数据集");
		codeSon3.setDisplayName("治疗-手术治疗费-手术费");
		observationSon3.setCode(codeSon3);
		CValue valueSon3 = new CValue();
		if(pat.getTc_opfee()==null)
			valueSon3.setValue(null);
		else
			valueSon3.setValue(pat.getTc_opfee().toString());
		observationSon3.setValue(valueSon3);
		entyRelationship3.setObservation(observationSon3);	
		entyRelationships.add(entyRelationship3);
		observation2.setEntyRelationship(entyRelationships);
		componentSon2.setObservation(observation2);
		components.add(componentSon2);
		organizer.setComponent(components);
		entryDi.setOrganizer(organizer);
		return entryDi;
	}
	
	
	/**
	 * 诊断类服务费
	 * @param pat
	 * @return
	 */
	private EntryHel2 getEntryDiBl(CiMrFpDTO pat) {
		EntryHel2 entryDi = new EntryHel2();
		OrganizerDi organizer = new OrganizerDi();
		organizer.setClassCode("CLUSTER");
		organizer.setMoodCode("EVN");
		List<ComponentSon> components = new ArrayList<ComponentSon>();
		ComponentSon componentSon1 = new ComponentSon();
		ObservationHel observation1 = new ObservationHel();
		CodeLife code1 = new CodeLife();
		code1.setCode("HDSD00.12.136");
		code1.setCodeSystem("2.16.156.10011.2.2.4");
		code1.setCodeSystemName("住院病案首页基本数据集");
		code1.setDisplayName("诊断-病理诊断费");
		observation1.setCode(code1);
		CValue value1 = new CValue();
		if(pat.getDi_pdifee()==null)
			value1.setValue(null);
		else
			value1.setValue(pat.getDi_pdifee().toString());
		value1.setCurrentcy("元");
		observation1.setCValue(value1);
		componentSon1.setObservation(observation1);
		components.add(componentSon1);
		
		ComponentSon componentSon2 = new ComponentSon();
		ObservationHel observation2 = new ObservationHel();
		CodeLife code2 = new CodeLife();
		code2.setCode("HDSD00.12.138");
		code2.setCodeSystem("2.16.156.10011.2.2.4");
		code2.setCodeSystemName("住院病案首页基本数据集");
		code2.setDisplayName("诊断-实验室诊断费");
		observation2.setCode(code2);
		CValue value2 = new CValue(); 
		if(pat.getDi_ldifee()==null)
			value2.setValue(null);
		else
			value2.setValue(pat.getDi_ldifee().toString());
		value2.setCurrentcy("元");
		observation2.setCValue(value2);
		componentSon2.setObservation(observation2);
		components.add(componentSon2);
		
		ComponentSon componentSon3 = new ComponentSon();
		ObservationHel observation3 = new ObservationHel();
		CodeLife code3 = new CodeLife();
		code3.setCode("HDSD00.12.139");
		code3.setCodeSystem("2.16.156.10011.2.2.4");
		code3.setCodeSystemName("住院病案首页基本数据集");
		code3.setDisplayName("诊断类-影像学诊断费");
		observation3.setCode(code3);
		CValue value3 = new CValue();
		if(pat.getDi_idifee()==null)
			value3.setValue(null);
		else
			value3.setValue(pat.getDi_idifee().toString());
		value3.setCurrentcy("元");
		observation3.setCValue(value3);
		componentSon3.setObservation(observation3);
		components.add(componentSon3);
		
		ComponentSon componentSon4 = new ComponentSon();
		ObservationHel observation4 = new ObservationHel();
		CodeLife code4 = new CodeLife();
		code4.setCode("HDSD00.12.137");
		code4.setCodeSystem("2.16.156.10011.2.2.4");
		code4.setCodeSystemName("住院病案首页基本数据集");
		code4.setDisplayName("诊断-临床诊断项目费");
		observation4.setCode(code4);
		CValue value4 = new CValue(); 
		if(pat.getDi_cdifee()==null)
			value4.setValue(null);
		else
			value4.setValue(pat.getDi_cdifee().toString());
		value4.setCurrentcy("元");
		observation4.setCValue(value4);
		componentSon4.setObservation(observation4);
		components.add(componentSon4);
		
		organizer.setComponent(components);
		entryDi.setOrganizer(organizer);
		return entryDi;
	}
	
	/**
	 * 综合医疗服务费
	 * @param pat
	 * @return
	 */
	private EntryHel2 getEntryZHBl(CiMrFpDTO pat) {
		EntryHel2 entryZH = new EntryHel2();
		OrganizerDi organizer = new OrganizerDi();
		organizer.setClassCode("CLUSTER");
		organizer.setMoodCode("EVN");
		List<ComponentSon> components = new ArrayList<ComponentSon>();
		ComponentSon componentSon1 = new ComponentSon();
		ObservationHel observation1 = new ObservationHel();
		CodeLife code1 = new CodeLife();
		code1.setCode("HDSD00.12.174");
		code1.setCodeSystem("2.16.156.10011.2.2.4");
		code1.setCodeSystemName("住院病案首页基本数据集");
		code1.setDisplayName("综合医疗服务费-一般医疗服务费");
		observation1.setCode(code1);
		CValue value1 = new CValue(); 
		if(pat.getCms_gmsfee()==null)
			value1.setValue(null);
		else
			value1.setValue(pat.getCms_gmsfee().toString());
		value1.setCurrentcy("元");
		observation1.setCValue(value1);
		componentSon1.setObservation(observation1);
		components.add(componentSon1);
		
		ComponentSon componentSon2 = new ComponentSon();
		ObservationHel observation2 = new ObservationHel();
		CodeLife code2 = new CodeLife();
		code2.setCode("HDSD00.12.175");
		code2.setCodeSystem("2.16.156.10011.2.2.4");
		code2.setCodeSystemName("住院病案首页基本数据集");
		code2.setDisplayName("综合医疗服务费-一般医疗服务费-中医辨证论治费");
		observation2.setCode(code2);
		CValue value2 = new CValue(); 
		if(pat.getCms_decnfee()==null)
			value2.setValue(null);
		else
			value2.setValue(pat.getCms_decnfee().toString());
		value2.setCurrentcy("元");
		observation2.setCValue(value2);
		componentSon2.setObservation(observation2);
		components.add(componentSon2);
		
		ComponentSon componentSon3 = new ComponentSon();
		ObservationHel observation3 = new ObservationHel();
		CodeLife code3 = new CodeLife();
		code3.setCode("HDSD00.12.176");
		code3.setCodeSystem("2.16.156.10011.2.2.4");
		code3.setCodeSystemName("住院病案首页基本数据集");
		code3.setDisplayName("综合医疗服务费-一般医疗服务费-中医辨证论治会诊费");
		observation3.setCode(code3);
		CValue value3 = new CValue(); 
		if(pat.getCms_decfee()==null)
			value3.setValue(null);
		else
			value3.setValue(pat.getCms_decfee().toString());
		value3.setCurrentcy("元");
		observation3.setCValue(value3);
		componentSon3.setObservation(observation3);
		components.add(componentSon3);
		
		ComponentSon componentSon4 = new ComponentSon();
		ObservationHel observation4 = new ObservationHel();
		CodeLife code4 = new CodeLife();
		code4.setCode("HDSD00.12.177");
		code4.setCodeSystem("2.16.156.10011.2.2.4");
		code4.setCodeSystemName("住院病案首页基本数据集");
		code4.setDisplayName("综合医疗服务费-一般治疗操作费");
		observation4.setCode(code4);
		CValue value4 = new CValue(); 
		if(pat.getCms_gtofee()==null)
			value4.setValue(null);
		else
			value4.setValue(pat.getCms_gtofee().toString());
		value4.setCurrentcy("元");
		observation4.setCValue(value4);
		componentSon4.setObservation(observation4);
		components.add(componentSon4);
		
		ComponentSon componentSon5 = new ComponentSon();
		ObservationHel observation5 = new ObservationHel();
		CodeLife code5 = new CodeLife();
		code5.setCode("HDSD00.12.172");
		code5.setCodeSystem("2.16.156.10011.2.2.4");
		code5.setCodeSystemName("住院病案首页基本数据集");
		code5.setDisplayName("综合医疗服务类-护理费");
		observation5.setCode(code5);
		CValue value5 = new CValue(); 
		if(pat.getCms_nurfee()==null)
			value5.setValue(null);
		else
			value5.setValue(pat.getCms_nurfee().toString());
		value5.setCurrentcy("元");
		observation5.setCValue(value5);
		componentSon5.setObservation(observation5);
		components.add(componentSon5);
		
		ComponentSon componentSon6 = new ComponentSon();
		ObservationHel observation6 = new ObservationHel();
		CodeLife code6 = new CodeLife();
		code6.setCode("HDSD00.12.173");
		code6.setCodeSystem("2.16.156.10011.2.2.4");
		code6.setCodeSystemName("住院病案首页基本数据集");
		code6.setDisplayName("综合医疗服务费-其他费用");
		observation6.setCode(code6);
		CValue value6 = new CValue(); 
		if(pat.getCms_otherfee()==null)
			value6.setValue(null);
		else
			value6.setValue(pat.getCms_otherfee().toString());
		value6.setCurrentcy("元");
		observation6.setCValue(value6);
		componentSon6.setObservation(observation6);
		components.add(componentSon6);
		organizer.setComponent(components);
		entryZH.setOrganizer(organizer);
		return entryZH;
	}

	/**
	 * 住院总费用
	 * @param pat
	 * @return
	 */
	private EntryHel getEntryTotalBl(CiMrFpDTO pat) {
		EntryHel entryTotal = new EntryHel();
		ObservationHel observation = new ObservationHel();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		Code codeTotal = new Code();
		codeTotal.setCode("HDSD00.12.169");
		codeTotal.setCodeSystem("2.16.156.10011.2.2.4");
		codeTotal.setCodeSystemName("住院病案首页基本数据集");
		codeTotal.setDisplayName("住院总费用");
		observation.setCode(codeTotal);
		CValue cvalue = new CValue();
		if(pat.getAmount()==null)
			cvalue.setValue(null);
		else
			cvalue.setValue(pat.getAmount().toString());
		cvalue.setCurrentcy("元");
		observation.setCValue(cvalue);
		List<EntryRelationship> entyRelationships = new ArrayList<EntryRelationship>();
		EntryRelationship entyRelationship = new EntryRelationship();
		entyRelationship.setTypeCode("COMP");
		entyRelationship.setNegationInd("false");
		Observation observationTotal = new Observation();
		observationTotal.setClassCode("OBS");
		observationTotal.setMoodCode("EVN");
		CodeLife codeTotalBl = new CodeLife();
		codeTotalBl.setCode("HDSD00.12.170");
		codeTotalBl.setCodeSystem("2.16.156.10011.2.2.4");
		codeTotalBl.setCodeSystemName("住院病案首页基本数据集");
		codeTotalBl.setDisplayName("住院总费用-自付金额（元）");
		observationTotal.setCode(codeTotalBl);
		CValue value = new CValue();
		if(pat.getCms_spamount()==null)
			value.setValue(null);
		else
			value.setValue(pat.getCms_spamount().toString());
		value.setCurrentcy("元");
		observationTotal.setValue(value);
		entyRelationship.setObservation(observationTotal);
		entyRelationships.add(entyRelationship);
		observation.setEntyRelationship(entyRelationships);
		entryTotal.setObservation(observation);
		return entryTotal;
	}

	/**
	 * 医疗付款方式
	 * @param pat
	 * @return
	 */
	private EntryLife getEntryType(CiMrFpDTO pat) {
		EntryLife entryType = new EntryLife();
		Observation observation = new Observation();
		observation.setClassCode("OBS");
		observation.setMoodCode("EVN");
		CodeLife codeType = new CodeLife();
		codeType.setCode("DE07.00.007.00");
		codeType.setCodeSystem("2.16.156.10011.2.2.1");
		codeType.setCodeSystemName("卫生信息数据元目录");
		codeType.setDisplayName("医疗付款方式代码");
		observation.setCode(codeType);
		Code valueType = new Code();
		valueType.setCode(pat.getSd_pay_method());
		valueType.setDisplayName(pat.getName_pay_method());
		valueType.setCodeSystem("2.16.156.10011.2.3.1.269");
		valueType.setCodeSystemName("医疗付费方式代码表");
		observation.setCvalue(valueType);
		entryType.setObservation(observation);
		return entryType;
	}
	
	/**
	 * 根据描述获得详细地址划分
	 * @param des
	 * @return
	 */
	private Address getDetailAdderss(String des)
	{
		/*
		 *中国现行的行政区划实行如下原则：
		 *一级省级行政区：分为省、自治区、直辖市、特别行政区；
		 *二级地级行政区：分为地级市、地区、自治州、盟；
		 *三级县级行政区：分为市辖区、县、自治县、县级市、旗、自治旗、林区、特区；
		 *四级乡级行政区：分为镇、乡、民族乡、街道、苏木、民族苏木、区公所；
		 *五级村级行政区：分为行政村、社区、居、嘎査；
		 *六级组级行政区：分为自然村村民小组、社区居民小组。
		 */
		
		Address addr = new Address();
		if(des==null)
		{
			addr.setState("");			
			addr.setCity("");
			addr.setCounty("");			
			addr.setTownship("");			
			addr.setStreetName("");			
			addr.setHoseNumber("");
			return addr;
		}
		String[] arrFirst = {"省","自治区","市","特别行政区"};
		String[] arrSecond = {"市","区","自治州","盟"};
		String[] arrThird = {"区","县","市","旗"};//结尾重复的过滤了
		String[] arrForth = {"镇","乡","街道","苏木","区公所"};
		String[] arrFifth = {"村","社区","居","嘎査"};
		String[] arrsixth = {"小组"};
		String region = "";
		region = SpiltRegion(arrFirst,des);		
		addr.setState(region==null?region:"");
		des = des.replace(region, "");
		region = SpiltRegion(arrSecond,des);
		addr.setCity(region==null?region:"");
		des = des.replace(region, "");
		region = SpiltRegion(arrThird,des);
		addr.setCounty(region==null?region:"");
		des = des.replace(region, "");
		region = SpiltRegion(arrForth,des);
		addr.setTownship(region==null?region:"");
		des = des.replace(region, "");
		region = SpiltRegion(arrFifth,des);
		addr.setStreetName(region==null?region:"");
		des = des.replace(region, "");
		addr.setHoseNumber(des==null?des:"");
		return addr;
	}
	
	/**
	 * 获取特定行政区
	 * @param standard
	 * @param des
	 * @return
	 */
	private String SpiltRegion(String[] standards, String des)
	{
		String region = "";
		if(standards!=null&&standards.length>0)
		{
			int idx = -1;
			for(int i =0;i<standards.length;i++)
			{
				idx = des.indexOf(standards[i]);
				if(idx!=-1)
				{
					region = des.substring(0,idx)+standards[i];
					break;
				}
			}
		}
		return region; 
	}
	
	/** 
     * 将对象直接转换成String类型的 XML输出 
     *  
     * @param obj 
     * @return 
     */  
    public static String convertToXml(Object obj) {  
        // 创建输出流  
        StringWriter sw = new StringWriter();  
        try {  
            // 利用jdk中自带的转换类实现  
            JAXBContext context = JAXBContext.newInstance(obj.getClass());  
  
            Marshaller marshaller = context.createMarshaller();  
            // 格式化xml输出的格式  
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,  
                    Boolean.TRUE);  
            // 将对象转换成输出流形式的xml  
            marshaller.marshal(obj, sw);  
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }  
        return sw.toString();  
    }  
    
    /** 
     * 将对象根据路径转换成xml文件 
     *  
     * @param obj 
     * @param path 
     * @return 
     */  
    public static void convertToXml(Object obj, String path) {  
        try {  
            // 利用jdk中自带的转换类实现  
            JAXBContext context = JAXBContext.newInstance(obj.getClass());  
  
            Marshaller marshaller = context.createMarshaller();  
            // 格式化xml输出的格式  
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,  
                    Boolean.TRUE);  
            // 将对象转换成输出流形式的xml  
            // 创建输出流  
            FileWriter fw = null;  
            try {  
                fw = new FileWriter(path);  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
            marshaller.marshal(obj, fw);  
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }  
    } 
	
}
