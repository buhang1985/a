package iih.ci.mr.s;

import iih.bd.bc.udi.pub.ICiMrDictCodeTypeConst;
import iih.bd.srv.medsrv.d.MedSrvVtDO;
import iih.bd.srv.mrtplvt.d.MrtplVtItmDO;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimrpatsigns.d.CiMrHisDataDTO;
import iih.ci.mr.cimrpatsigns.d.PatDTO;
import iih.ci.mr.cimrpatsigns.d.Patparam;
import iih.ci.mr.d.MrTreeListDTO;
import iih.ci.mr.d.WaitDoctorDto;
import iih.ci.mr.i.ICiMrServiceExt;
import iih.ci.mr.knowledge.d.Knowledgedto;
import iih.ci.mr.s.bp.CiMrHisDataBp;
import iih.ci.mr.s.bp.DataElementBp;
import iih.ci.mr.s.bp.FindPatDTOBp;
import iih.ci.mr.s.bp.MrTreeListBp;
import iih.ci.mr.s.bp.MrVtItemBp;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.ListUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

@Service(serviceInterfaces = { ICiMrServiceExt.class }, binding = Binding.JSONRPC)
public class CiMrServiceExtImpl implements ICiMrServiceExt {

	/**
	 * 患者列表检索
	 */
	@Override
	public PatDTO[] FindPatDTO(Patparam patparam) throws BizException {

		FindPatDTOBp bp = new FindPatDTOBp();

		return bp.exec(patparam);
	}

	/**
	 * 获取医疗服务（生命体征属性）
	 */
	@Override
	public MedSrvVtDO[] getMedSrvVtDO(String Id_mrvtca) throws BizException {

		DataElementBp Bp = new DataElementBp();

		return Bp.exec(Id_mrvtca);
	}

	/**
	 * 根据体征模板获取体征测量项目
	 */
	@Override
	public MrtplVtItmDO[] getMrtplVtItmDO(String id_mrtplvt) throws BizException {

		MrVtItemBp Bp = new MrVtItemBp();

		return Bp.exec(id_mrtplvt);
	}

	/**
	 * 获取患者的历史体征信息
	 */
	@Override
	public CiMrHisDataDTO[] getCiMrHisData(String id_ents, String id_mrtplvt, String dt_vt) throws BizException {

		CiMrHisDataBp Bp = new CiMrHisDataBp();

		return Bp.exec(id_ents, id_mrtplvt, dt_vt);
	}

	@Override
	public MrTreeListDTO[] getMrTreeList(String name) throws BizException {
		// TODO Auto-generated method stub
		MrTreeListBp bp = new MrTreeListBp();
		return bp.exe();
	}
	
	@Override
	public Knowledgedto[] GetKnowledges(String id_user,String gr) throws BizException {
		DAFacade daf = new DAFacade();

    	String sql1 =
    			"select mm.Id_knowledge_type as id_knowledge_type,mm.name as category,nn.name as name ,nn.id_knowledge as id_knowledge,\n"
    			+ "nn.knowledge_content as knowledge_content,\n"
    			+ "mm.attribute as attribute ,mm.personal as personal,\n"
    			+ "mm.administrative as administrative,nn.id_user\n"
    			+ "from ci_mr_knowledge_type mm\n"
    			+ "left outer join ci_mr_knowledge nn on mm.id_knowledge_type =nn.id_knowledge_type\n"
    			+ "where nn.id_user ='"+id_user+"' and mm.attribute = '"+gr+"' and nn.ds='"+0+"'";
    	
       @SuppressWarnings("unchecked")
       List<Knowledgedto> listMr1 = (List<Knowledgedto>) daf.execQuery(sql1, new BeanListHandler(Knowledgedto.class));
      
       return (Knowledgedto[]) listMr1.toArray(new Knowledgedto[0]);
	}

	@Override
	public Knowledgedto[] GetKnowledge(String id_user,String id_dept,String grName,String ksName) throws BizException {
		DAFacade daf = new DAFacade();

    	String sql1 =
    			"select mm.Id_knowledge_type as id_knowledge_type,mm.name as category,nn.name as name ,nn.knowledge_content as knowledge_content,\n"
    			+ "mm.attribute as attribute ,nn.id_knowledge as id_knowledge,mm.personal as personal,\n"
    			+ "mm.administrative as administrative,nn.id_user\n"
    			+ "from ci_mr_knowledge_type mm\n"
    			+ "left outer join ci_mr_knowledge nn on mm.id_knowledge_type =nn.id_knowledge_type\n"
    			+ "where nn.id_dept='"+id_dept+"' and mm.attribute='"+ksName+"' and fg_active='Y'  and  nn.ds='0'\n"
    					+ "union all \n"
    					+ "select mm.Id_knowledge_type as id_knowledge_type,mm.name as category,nn.name as name ,nn.knowledge_content as knowledge_content,\n"
    					+ "mm.attribute as attribute ,nn.id_knowledge as id_knowledge,mm.personal as personal,\n"
    					+ "mm.administrative as administrative,nn.id_user\n"
    					+ "from ci_mr_knowledge_type mm\n"
    					+ "left outer join ci_mr_knowledge nn on mm.id_knowledge_type =nn.id_knowledge_type\n"
    					+ "where nn.id_user ='"+id_user+"' and mm.attribute='"+grName+"' and fg_active='Y' and  nn.ds='0'";
    	
       @SuppressWarnings("unchecked")
       List<Knowledgedto> listMr1 = (List<Knowledgedto>) daf.execQuery(sql1, new BeanListHandler(Knowledgedto.class));
      
       return (Knowledgedto[]) listMr1.toArray(new Knowledgedto[0]);
	}

	@Override
	public Knowledgedto[] GetKnowledgeks(String id_dept,String ks) throws BizException {
		DAFacade daf = new DAFacade();

    	String sql1 =
    			"select mm.Id_knowledge_type as id_knowledge_type,mm.name as category,nn.name as name ,nn.knowledge_content as knowledge_content,\n"
    			+ "mm.attribute as attribute ,nn.id_knowledge as id_knowledge,mm.personal as personal,\n"
    			+ "mm.administrative as administrative,nn.id_user\n"
    			+ "from ci_mr_knowledge_type mm\n"
    			+ "left outer join ci_mr_knowledge nn on mm.id_knowledge_type =nn.id_knowledge_type\n"
    			+ "where nn.id_dept ='"+id_dept+"' and mm.attribute ='"+ks+"' and fg_active='Y' and nn.ds='"+0+"'";
    	
       @SuppressWarnings("unchecked")
       List<Knowledgedto> listMr1 = (List<Knowledgedto>) daf.execQuery(sql1, new BeanListHandler(Knowledgedto.class));
      
       return (Knowledgedto[]) listMr1.toArray(new Knowledgedto[0]);
	}

	@Override
	public Knowledgedto[] GetKnowledgeName(String id_user,String id_dept,String grName,String ksName,String name) throws BizException {
		DAFacade daf = new DAFacade();

    	String sql1 =
    			"select mm.Id_knowledge_type as id_knowledge_type,mm.name as category,nn.name as name ,nn.knowledge_content as knowledge_content,\n"
    	    			+ "mm.attribute as attribute ,nn.id_knowledge as id_knowledge,mm.personal as personal,\n"
    	    			+ "mm.administrative as administrative,nn.id_user\n"
    	    			+ "from ci_mr_knowledge_type mm\n"
    	    			+ "left outer join ci_mr_knowledge nn on mm.id_knowledge_type =nn.id_knowledge_type\n"
    	    			+ "where nn.id_dept='"+id_dept+"' and mm.attribute='"+ksName+"' and nn.name like '%"+name+"%' and  nn.ds='0'\n"
    	    					+ "union all \n"
    	    					+ "select mm.Id_knowledge_type as id_knowledge_type,mm.name as category,nn.name as name ,nn.knowledge_content as knowledge_content,\n"
    	    					+ "mm.attribute as attribute ,nn.id_knowledge as id_knowledge,mm.personal as personal,\n"
    	    					+ "mm.administrative as administrative,nn.id_user\n"
    	    					+ "from ci_mr_knowledge_type mm\n"
    	    					+ "left outer join ci_mr_knowledge nn on mm.id_knowledge_type =nn.id_knowledge_type\n"
    	    					+ "where nn.id_user ='"+id_user+"' and mm.attribute='"+grName+"' and nn.name like '%"+name+"%' and  nn.ds='0'"; 
    	
       @SuppressWarnings("unchecked")
       List<Knowledgedto> listMr1 = (List<Knowledgedto>) daf.execQuery(sql1, new BeanListHandler(Knowledgedto.class));
      
       return (Knowledgedto[]) listMr1.toArray(new Knowledgedto[0]);
	}
	
	@Override
	public Knowledgedto[] GetKnowledgeksName(String id_dept,String ksName, String name) throws BizException {
		DAFacade daf = new DAFacade();

    	String sql1 =
    			"select mm.Id_knowledge_type as id_knowledge_type,mm.name as category,nn.name as name ,nn.knowledge_content as knowledge_content,\n"
    			+ "mm.attribute as attribute ,nn.id_knowledge as id_knowledge,mm.personal as personal,\n"
    			+ "mm.administrative as administrative,nn.id_user\n"
    			+ "from ci_mr_knowledge_type mm\n"
    			+ "left outer join ci_mr_knowledge nn on mm.id_knowledge_type =nn.id_knowledge_type\n"
    			+ "where nn.id_dept ='"+id_dept+"' and mm.attribute='"+ksName+"' and nn.name like '%"+name+"%' and nn.ds='"+0+"'";
    	
       @SuppressWarnings("unchecked")
       List<Knowledgedto> listMr1 = (List<Knowledgedto>) daf.execQuery(sql1, new BeanListHandler(Knowledgedto.class));
      
       return (Knowledgedto[]) listMr1.toArray(new Knowledgedto[0]);
	}

	@Override
	public Knowledgedto[] GetKnowledgeNamegr(String id_user,String grName ,String name) throws BizException {
		DAFacade daf = new DAFacade();

    	String sql1 =
    			"select mm.Id_knowledge_type as id_knowledge_type,mm.name as category,nn.name as name ,nn.knowledge_content as knowledge_content,\n"
    			+ "mm.attribute as attribute,nn.id_knowledge as id_knowledge ,mm.personal as personal,\n"
    			+ "mm.administrative as administrative,nn.id_user\n"
    			+ "from ci_mr_knowledge_type mm\n"
    			+ "left outer join ci_mr_knowledge nn on mm.id_knowledge_type =nn.id_knowledge_type\n"
    			+ "where nn.id_user ='"+id_user+"' and mm.attribute='"+grName+"' and nn.name like '%"+name+"%' and nn.ds='"+0+"'";
    	
       @SuppressWarnings("unchecked")
       List<Knowledgedto> listMr1 = (List<Knowledgedto>) daf.execQuery(sql1, new BeanListHandler(Knowledgedto.class));
      
       return (Knowledgedto[]) listMr1.toArray(new Knowledgedto[0]);
	}

	@Override
	public WaitDoctorDto[] getWaitDoctorDto(String id_user, String id_dep_phy,
			String sd_status) throws BizException {
		DAFacade daf = new DAFacade();

    	String sql1 =

			"select ee.id_ent,\n" +
			"       ee.name_pat,\n" + 
			"       (case when pp.dt_birth ='' then 0 else\n" + 
			"       trunc(to_number(to_char(sysdate, 'yyyy')) -\n" + 
			"             to_number(substr(dt_birth, 1, 4))) end) pat_age,\n" + 
			"       bu.id_udidoclist,\n" + 
			"       ee.code,\n" + 
			"       ee.addr_pat,\n" + 
			"       bu.name id_sex_pat,\n" + 
			"       ee.dt_acpt,\n" + 
			"       eed.NAME_DIDEF_DIS di_des,\n" + 
			"       ppc.name patca_name,\n" + 
			"       ee.dt_end\n" + 
			"  from en_ent ee\n" + 
			"  left join en_ent_di eed\n" + 
			"    on ee.id_ent = eed.id_ent and eed.id_ent <> '~'\n" + 
			"   and eed.fg_maj = 'Y'\n" + 
			"  left join en_ent_que eeq\n" + 
			"    on eeq.id_ent = ee.id_ent\n" + 
			"  left join pi_pat pp\n" + 
			"    on ee.id_pat = pp.id_pat\n" + 
			"  left join pi_pat_ca ppc\n" + 
			"    on pp.id_paticate = ppc.id_patca and pp.id_paticate <> '~'\n" + 
			"  left join bd_udidoc bu\n" + 
			"    on bu.id_udidoclist = '"+ICiMrDictCodeTypeConst.ID_UDIDOCLIST_SEX+"'\n" + 
			"   and pp.id_sex = bu.id_udidoc\n" + 
			"  join sys_user su\n" + 
			"  on su.id_psn = ee.id_emp_phy and ee.id_emp_phy <>'~'\n" + 
			"\n" + 
			" where ee.code_entp = '00' and su.id_user like '"+id_user+"%' and ee.id_dep_phy like '"+id_dep_phy+"%'\n" + 
			"and eeq.sd_status_acpt in ("+sd_status+")";

    	
       @SuppressWarnings("unchecked")
       List<WaitDoctorDto> listMr1 = (List<WaitDoctorDto>) daf.execQuery(sql1, new BeanListHandler(WaitDoctorDto.class));
      
       return (WaitDoctorDto[]) listMr1.toArray(new WaitDoctorDto[0]);
	}

	@Override
	public WaitDoctorDto[] queryWaitDoctorDto(String code, String name,
			String dt_acpt, String dt_end, String id_user, String id_dep_phy,
			String sd_status) throws BizException {
		
		DAFacade daf = new DAFacade();
		String sql1 = null;
		if(code != "" && name == "" && dt_acpt == "" && dt_end == "")
		{
			 sql1 =
					"select ee.id_ent,\n" +
					"       ee.name_pat,\n" + 
					"       (case when pp.dt_birth ='' then 0 else\n" + 
					"       trunc(to_number(to_char(sysdate, 'yyyy')) -\n" + 
					"             to_number(substr(dt_birth, 1, 4))) end) pat_age,\n" + 
					"       bu.id_udidoclist,\n" + 
					"       ee.code,\n" + 
					"       ee.addr_pat,\n" + 
					"       bu.name id_sex_pat,\n" + 
					"       ee.dt_acpt,\n" + 
//					"       (case\n" + 
//					"         when eed.name_di is null or eed.name_di = '' then\n" + 
//					"          eed.des\n" + 
//					"         else\n" + 
//					"          name_di\n" + 
//					"       end) di_des,\n" + 
					"       ppc.name patca_name,\n" + 
					"       ee.dt_end\n" + 
					"  from en_ent ee\n" + 
					"  left join en_ent_di eed\n" + 
					"    on ee.id_ent = eed.id_ent and eed.id_ent <> '~'\n" + 
					"   and eed.fg_maj = 'Y'\n" + 
					"  left join en_ent_que eeq\n" + 
					"    on eeq.id_ent = ee.id_ent\n" + 
					"  left join pi_pat pp\n" + 
					"    on ee.id_pat = pp.id_pat\n" + 
					"  left join pi_pat_ca ppc\n" + 
					"    on pp.id_paticate = ppc.id_patca and pp.id_paticate <> '~'\n" + 
					"  left join bd_udidoc bu\n" + 
					"    on bu.id_udidoclist = '"+ICiMrDictCodeTypeConst.ID_UDIDOCLIST_SEX+"'\n" + 
					"   and pp.id_sex = bu.id_udidoc\n" + 
					"  join sys_user su\n" + 
					"  on su.id_psn = ee.id_emp_phy and ee.id_emp_phy <>'~'\n" + 
					"\n" + 
					" where ee.code_entp = '00' and su.id_user like '"+id_user+"%' and ee.id_dep_phy like '"+id_dep_phy+"%'\n" + 
					"and eeq.sd_status_acpt in ("+sd_status+") and ee.code like '"+code+"%'";
		}
		
		else if(code != "" && name != "" && dt_acpt == "" && dt_end == "")
		{
			 sql1 =
					"select ee.id_ent,\n" +
					"       ee.name_pat,\n" + 
					"       (case when pp.dt_birth ='' then 0 else\n" + 
					"       trunc(to_number(to_char(sysdate, 'yyyy')) -\n" + 
					"             to_number(substr(dt_birth, 1, 4))) end) pat_age,\n" + 
					"       bu.id_udidoclist,\n" + 
					"       ee.code,\n" + 
					"       ee.addr_pat,\n" + 
					"       bu.name id_sex_pat,\n" + 
					"       ee.dt_acpt,\n" + 
//					"       (case\n" + 
//					"         when eed.name_di is null or eed.name_di = '' then\n" + 
//					"          eed.des\n" + 
//					"         else\n" + 
//					"          name_di\n" + 
//					"       end) di_des,\n" + 
					"       ppc.name patca_name,\n" + 
					"       ee.dt_end\n" + 
					"  from en_ent ee\n" + 
					"  left join en_ent_di eed\n" + 
					"    on ee.id_ent = eed.id_ent and eed.id_ent <> '~'\n" + 
					"   and eed.fg_maj = 'Y'\n" + 
					"  left join en_ent_que eeq\n" + 
					"    on eeq.id_ent = ee.id_ent\n" + 
					"  left join pi_pat pp\n" + 
					"    on ee.id_pat = pp.id_pat\n" + 
					"  left join pi_pat_ca ppc\n" + 
					"    on pp.id_paticate = ppc.id_patca and pp.id_paticate <> '~'\n" + 
					"  left join bd_udidoc bu\n" + 
					"    on bu.id_udidoclist = '"+ICiMrDictCodeTypeConst.ID_UDIDOCLIST_SEX+"'\n" + 
					"   and pp.id_sex = bu.id_udidoc\n" + 
					"  join sys_user su\n" + 
					"  on su.id_psn = ee.id_emp_phy and ee.id_emp_phy <>'~'\n" + 
					"\n" + 
					" where ee.code_entp = '00' and su.id_user like '"+id_user+"%' and ee.id_dep_phy like '"+id_dep_phy+"%'\n" + 
					"and eeq.sd_status_acpt in ("+sd_status+") and ee.code like '"+code+"%' and ee.name_pat like '"+name+"%'";
		}
		else if(code != "" && name != "" && dt_acpt != "" && dt_end != "")
		{
			 sql1 =
					"select ee.id_ent,\n" +
					"       ee.name_pat,\n" + 
					"       (case when pp.dt_birth ='' then 0 else\n" + 
					"       trunc(to_number(to_char(sysdate, 'yyyy')) -\n" + 
					"             to_number(substr(dt_birth, 1, 4))) end) pat_age,\n" + 
					"       bu.id_udidoclist,\n" + 
					"       ee.code,\n" + 
					"       ee.addr_pat,\n" + 
					"       bu.name id_sex_pat,\n" + 
					"       ee.dt_acpt,\n" + 
//					"       (case\n" + 
//					"         when eed.name_di is null or eed.name_di = '' then\n" + 
//					"          eed.des\n" + 
//					"         else\n" + 
//					"          name_di\n" + 
//					"       end) di_des,\n" + 
					"       ppc.name patca_name,\n" + 
					"       ee.dt_end\n" + 
					"  from en_ent ee\n" + 
					"  left join en_ent_di eed\n" + 
					"    on ee.id_ent = eed.id_ent and eed.id_ent <> '~'\n" + 
					"   and eed.fg_maj = 'Y'\n" + 
					"  left join en_ent_que eeq\n" + 
					"    on eeq.id_ent = ee.id_ent\n" + 
					"  left join pi_pat pp\n" + 
					"    on ee.id_pat = pp.id_pat\n" + 
					"  left join pi_pat_ca ppc\n" + 
					"    on pp.id_paticate = ppc.id_patca and pp.id_paticate <> '~'\n" + 
					"  left join bd_udidoc bu\n" + 
					"    on bu.id_udidoclist = '"+ICiMrDictCodeTypeConst.ID_UDIDOCLIST_SEX+"'\n" + 
					"   and pp.id_sex = bu.id_udidoc\n" + 
					"  join sys_user su\n" + 
					"  on su.id_psn = ee.id_emp_phy and ee.id_emp_phy <>'~'\n" + 
					"\n" + 
					" where ee.code_entp = '00' and su.id_user like '"+id_user+"%' and ee.id_dep_phy like '"+id_dep_phy+"%'\n" + 
					"and eeq.sd_status_acpt in ("+sd_status+") and ee.code like '"+code+"%' and ee.name_pat like '"+name+"%'\n"
							+ " and ee.dt_acpt >='"+dt_acpt+"' and ee.dt_acpt <='"+dt_end+"'";
		}
		else if(code == "" && name != "" && dt_acpt != "" && dt_end != "")
		{
			 sql1 =
					"select ee.id_ent,\n" +
					"       ee.name_pat,\n" + 
					"       (case when pp.dt_birth ='' then 0 else\n" + 
					"       trunc(to_number(to_char(sysdate, 'yyyy')) -\n" + 
					"             to_number(substr(dt_birth, 1, 4))) end) pat_age,\n" + 
					"       bu.id_udidoclist,\n" + 
					"       ee.code,\n" + 
					"       ee.addr_pat,\n" + 
					"       bu.name id_sex_pat,\n" + 
					"       ee.dt_acpt,\n" + 
//					"       (case\n" + 
//					"         when eed.name_di is null or eed.name_di = '' then\n" + 
//					"          eed.des\n" + 
//					"         else\n" + 
//					"          name_di\n" + 
//					"       end) di_des,\n" + 
					"       ppc.name patca_name,\n" + 
					"       ee.dt_end\n" + 
					"  from en_ent ee\n" + 
					"  left join en_ent_di eed\n" + 
					"    on ee.id_ent = eed.id_ent and eed.id_ent <> '~'\n" + 
					"   and eed.fg_maj = 'Y'\n" + 
					"  left join en_ent_que eeq\n" + 
					"    on eeq.id_ent = ee.id_ent\n" + 
					"  left join pi_pat pp\n" + 
					"    on ee.id_pat = pp.id_pat\n" + 
					"  left join pi_pat_ca ppc\n" + 
					"    on pp.id_paticate = ppc.id_patca and pp.id_paticate <> '~'\n" + 
					"  left join bd_udidoc bu\n" + 
					"    on bu.id_udidoclist = '"+ICiMrDictCodeTypeConst.ID_UDIDOCLIST_SEX+"'\n" + 
					"   and pp.id_sex = bu.id_udidoc\n" + 
					"  join sys_user su\n" + 
					"  on su.id_psn = ee.id_emp_phy and ee.id_emp_phy <>'~'\n" + 
					"\n" + 
					" where ee.code_entp = '00' and su.id_user like '"+id_user+"%' and ee.id_dep_phy like '"+id_dep_phy+"%'\n" + 
					"and eeq.sd_status_acpt in ("+sd_status+")  and ee.name_pat like '"+name+"%'\n"
							+ " and ee.dt_acpt >='"+dt_acpt+"' and ee.dt_acpt <='"+dt_end+"'";
		}
		else if(code == "" && name == "" && dt_acpt != "" && dt_end != "")
		{
			 sql1 =
					"select ee.id_ent,\n" +
					"       ee.name_pat,\n" + 
					"       (case when pp.dt_birth ='' then 0 else\n" + 
					"       trunc(to_number(to_char(sysdate, 'yyyy')) -\n" + 
					"             to_number(substr(dt_birth, 1, 4))) end) pat_age,\n" + 
					"       bu.id_udidoclist,\n" + 
					"       ee.code,\n" + 
					"       ee.addr_pat,\n" + 
					"       bu.name id_sex_pat,\n" + 
					"       ee.dt_acpt,\n" + 
//					"       (case\n" + 
//					"         when eed.name_di is null or eed.name_di = '' then\n" + 
//					"          eed.des\n" + 
//					"         else\n" + 
//					"          name_di\n" + 
//					"       end) di_des,\n" + 
					"       ppc.name patca_name,\n" + 
					"       ee.dt_end\n" + 
					"  from en_ent ee\n" + 
					"  left join en_ent_di eed\n" + 
					"    on ee.id_ent = eed.id_ent and eed.id_ent <> '~'\n" + 
					"   and eed.fg_maj = 'Y'\n" + 
					"  left join en_ent_que eeq\n" + 
					"    on eeq.id_ent = ee.id_ent\n" + 
					"  left join pi_pat pp\n" + 
					"    on ee.id_pat = pp.id_pat\n" + 
					"  left join pi_pat_ca ppc\n" + 
					"    on pp.id_paticate = ppc.id_patca and pp.id_paticate <> '~'\n" + 
					"  left join bd_udidoc bu\n" + 
					"    on bu.id_udidoclist = '"+ICiMrDictCodeTypeConst.ID_UDIDOCLIST_SEX+"'\n" + 
					"   and pp.id_sex = bu.id_udidoc\n" + 
					"  join sys_user su\n" + 
					"  on su.id_psn = ee.id_emp_phy and ee.id_emp_phy <>'~'\n" + 
					"\n" + 
					" where ee.code_entp = '00' and su.id_user like '"+id_user+"%' and ee.id_dep_phy like '"+id_dep_phy+"%'\n" + 
					"and eeq.sd_status_acpt in ("+sd_status+") \n"
							+ " and ee.dt_acpt >='"+dt_acpt+"' and ee.dt_acpt <='"+dt_end+"'";
		}
		else if(code == "" && name == "" && dt_acpt != "" && dt_end == "")
		{
			 sql1 =
					"select ee.id_ent,\n" +
					"       ee.name_pat,\n" + 
					"       (case when pp.dt_birth ='' then 0 else\n" + 
					"       trunc(to_number(to_char(sysdate, 'yyyy')) -\n" + 
					"             to_number(substr(dt_birth, 1, 4))) end) pat_age,\n" + 
					"       bu.id_udidoclist,\n" + 
					"       ee.code,\n" + 
					"       ee.addr_pat,\n" + 
					"       bu.name id_sex_pat,\n" + 
					"       ee.dt_acpt,\n" + 
//					"       (case\n" + 
//					"         when eed.name_di is null or eed.name_di = '' then\n" + 
//					"          eed.des\n" + 
//					"         else\n" + 
//					"          name_di\n" + 
//					"       end) di_des,\n" + 
					"       ppc.name patca_name,\n" + 
					"       ee.dt_end\n" + 
					"  from en_ent ee\n" + 
					"  left join en_ent_di eed\n" + 
					"    on ee.id_ent = eed.id_ent and eed.id_ent <> '~'\n" + 
					"   and eed.fg_maj = 'Y'\n" + 
					"  left join en_ent_que eeq\n" + 
					"    on eeq.id_ent = ee.id_ent\n" + 
					"  left join pi_pat pp\n" + 
					"    on ee.id_pat = pp.id_pat\n" + 
					"  left join pi_pat_ca ppc\n" + 
					"    on pp.id_paticate = ppc.id_patca and pp.id_paticate <> '~'\n" + 
					"  left join bd_udidoc bu\n" + 
					"    on bu.id_udidoclist = '"+ICiMrDictCodeTypeConst.ID_UDIDOCLIST_SEX+"'\n" + 
					"   and pp.id_sex = bu.id_udidoc\n" + 
					"  join sys_user su\n" + 
					"  on su.id_psn = ee.id_emp_phy and ee.id_emp_phy <>'~'\n" + 
					"\n" + 
					" where ee.code_entp = '00' and su.id_user like '"+id_user+"%' and ee.id_dep_phy like '"+id_dep_phy+"%'\n" + 
					"and eeq.sd_status_acpt in ("+sd_status+") \n"
							+ " and ee.dt_acpt >='"+dt_acpt+"'";
		}
		else if(code == "" && name == "" && dt_acpt == "" && dt_end != "")
		{
			 sql1 =
					"select ee.id_ent,\n" +
					"       ee.name_pat,\n" + 
					"       (case when pp.dt_birth ='' then 0 else\n" + 
					"       trunc(to_number(to_char(sysdate, 'yyyy')) -\n" + 
					"             to_number(substr(dt_birth, 1, 4))) end) pat_age,\n" + 
					"       bu.id_udidoclist,\n" + 
					"       ee.code,\n" + 
					"       ee.addr_pat,\n" + 
					"       bu.name id_sex_pat,\n" + 
					"       ee.dt_acpt,\n" + 
//					"       (case\n" + 
//					"         when eed.name_di is null or eed.name_di = '' then\n" + 
//					"          eed.des\n" + 
//					"         else\n" + 
//					"          name_di\n" + 
//					"       end) di_des,\n" + 
					"       ppc.name patca_name,\n" + 
					"       ee.dt_end\n" + 
					"  from en_ent ee\n" + 
					"  left join en_ent_di eed\n" + 
					"    on ee.id_ent = eed.id_ent and eed.id_ent <> '~'\n" + 
					"   and eed.fg_maj = 'Y'\n" + 
					"  left join en_ent_que eeq\n" + 
					"    on eeq.id_ent = ee.id_ent\n" + 
					"  left join pi_pat pp\n" + 
					"    on ee.id_pat = pp.id_pat\n" + 
					"  left join pi_pat_ca ppc\n" + 
					"    on pp.id_paticate = ppc.id_patca and pp.id_paticate <> '~'\n" + 
					"  left join bd_udidoc bu\n" + 
					"    on bu.id_udidoclist = '"+ICiMrDictCodeTypeConst.ID_UDIDOCLIST_SEX+"'\n" + 
					"   and pp.id_sex = bu.id_udidoc\n" + 
					"  join sys_user su\n" + 
					"  on su.id_psn = ee.id_emp_phy and ee.id_emp_phy <>'~'\n" + 
					"\n" + 
					" where ee.code_entp = '00' and su.id_user like '"+id_user+"%' and ee.id_dep_phy like '"+id_dep_phy+"%'\n" + 
					"and eeq.sd_status_acpt in ("+sd_status+") \n"
							+ " and ee.dt_acpt <='"+dt_end+"'";
		}
		else if(code != "" && name == "" && dt_acpt != "" && dt_end == "")
		{
			 sql1 =
					"select ee.id_ent,\n" +
					"       ee.name_pat,\n" + 
					"       (case when pp.dt_birth ='' then 0 else\n" + 
					"       trunc(to_number(to_char(sysdate, 'yyyy')) -\n" + 
					"             to_number(substr(dt_birth, 1, 4))) end) pat_age,\n" + 
					"       bu.id_udidoclist,\n" + 
					"       ee.code,\n" + 
					"       ee.addr_pat,\n" + 
					"       bu.name id_sex_pat,\n" + 
					"       ee.dt_acpt,\n" + 
//					"       (case\n" + 
//					"         when eed.name_di is null or eed.name_di = '' then\n" + 
//					"          eed.des\n" + 
//					"         else\n" + 
//					"          name_di\n" + 
//					"       end) di_des,\n" + 
					"       ppc.name patca_name,\n" + 
					"       ee.dt_end\n" + 
					"  from en_ent ee\n" + 
					"  left join en_ent_di eed\n" + 
					"    on ee.id_ent = eed.id_ent and eed.id_ent <> '~'\n" + 
					"   and eed.fg_maj = 'Y'\n" + 
					"  left join en_ent_que eeq\n" + 
					"    on eeq.id_ent = ee.id_ent\n" + 
					"  left join pi_pat pp\n" + 
					"    on ee.id_pat = pp.id_pat\n" + 
					"  left join pi_pat_ca ppc\n" + 
					"    on pp.id_paticate = ppc.id_patca and pp.id_paticate <> '~'\n" + 
					"  left join bd_udidoc bu\n" + 
					"    on bu.id_udidoclist = '"+ICiMrDictCodeTypeConst.ID_UDIDOCLIST_SEX+"'\n" + 
					"   and pp.id_sex = bu.id_udidoc\n" + 
					"  join sys_user su\n" + 
					"  on su.id_psn = ee.id_emp_phy and ee.id_emp_phy <>'~'\n" + 
					"\n" + 
					" where ee.code_entp = '00' and su.id_user like '"+id_user+"%' and ee.id_dep_phy like '"+id_dep_phy+"%'\n" + 
					"and eeq.sd_status_acpt in ("+sd_status+") and ee.code like '"+code+"%'\n"
							+ " and ee.dt_acpt >='"+dt_acpt+"'";
		}
		else if(code != "" && name != "" && dt_acpt != "" && dt_end == "")
		{
			 sql1 =
					"select ee.id_ent,\n" +
					"       ee.name_pat,\n" + 
					"       (case when pp.dt_birth ='' then 0 else\n" + 
					"       trunc(to_number(to_char(sysdate, 'yyyy')) -\n" + 
					"             to_number(substr(dt_birth, 1, 4))) end) pat_age,\n" + 
					"       bu.id_udidoclist,\n" + 
					"       ee.code,\n" + 
					"       ee.addr_pat,\n" + 
					"       bu.name id_sex_pat,\n" + 
					"       ee.dt_acpt,\n" + 
//					"       (case\n" + 
//					"         when eed.name_di is null or eed.name_di = '' then\n" + 
//					"          eed.des\n" + 
//					"         else\n" + 
//					"          name_di\n" + 
//					"       end) di_des,\n" + 
					"       ppc.name patca_name,\n" + 
					"       ee.dt_end\n" + 
					"  from en_ent ee\n" + 
					"  left join en_ent_di eed\n" + 
					"    on ee.id_ent = eed.id_ent and eed.id_ent <> '~'\n" + 
					"   and eed.fg_maj = 'Y'\n" + 
					"  left join en_ent_que eeq\n" + 
					"    on eeq.id_ent = ee.id_ent\n" + 
					"  left join pi_pat pp\n" + 
					"    on ee.id_pat = pp.id_pat\n" + 
					"  left join pi_pat_ca ppc\n" + 
					"    on pp.id_paticate = ppc.id_patca and pp.id_paticate <> '~'\n" + 
					"  left join bd_udidoc bu\n" + 
					"    on bu.id_udidoclist = '"+ICiMrDictCodeTypeConst.ID_UDIDOCLIST_SEX+"'\n" + 
					"   and pp.id_sex = bu.id_udidoc\n" + 
					"  join sys_user su\n" + 
					"  on su.id_psn = ee.id_emp_phy and ee.id_emp_phy <>'~'\n" + 
					"\n" + 
					" where ee.code_entp = '00' and su.id_user like '"+id_user+"%' and ee.id_dep_phy like '"+id_dep_phy+"%'\n" + 
					"and eeq.sd_status_acpt in ("+sd_status+") and ee.code like '"+code+"%' and ee.name_pat like '"+name+"%'\n"
							+ " and ee.dt_acpt >='"+dt_acpt+"'";
		}
		else if(code != "" && name != "" && dt_acpt == "" && dt_end != "")
		{
			 sql1 =
					"select ee.id_ent,\n" +
					"       ee.name_pat,\n" + 
					"       (case when pp.dt_birth ='' then 0 else\n" + 
					"       trunc(to_number(to_char(sysdate, 'yyyy')) -\n" + 
					"             to_number(substr(dt_birth, 1, 4))) end) pat_age,\n" + 
					"       bu.id_udidoclist,\n" + 
					"       ee.code,\n" + 
					"       ee.addr_pat,\n" + 
					"       bu.name id_sex_pat,\n" + 
					"       ee.dt_acpt,\n" + 
//					"       (case\n" + 
//					"         when eed.name_di is null or eed.name_di = '' then\n" + 
//					"          eed.des\n" + 
//					"         else\n" + 
//					"          name_di\n" + 
//					"       end) di_des,\n" + 
					"       ppc.name patca_name,\n" + 
					"       ee.dt_end\n" + 
					"  from en_ent ee\n" + 
					"  left join en_ent_di eed\n" + 
					"    on ee.id_ent = eed.id_ent and eed.id_ent <> '~'\n" + 
					"   and eed.fg_maj = 'Y'\n" + 
					"  left join en_ent_que eeq\n" + 
					"    on eeq.id_ent = ee.id_ent\n" + 
					"  left join pi_pat pp\n" + 
					"    on ee.id_pat = pp.id_pat\n" + 
					"  left join pi_pat_ca ppc\n" + 
					"    on pp.id_paticate = ppc.id_patca and pp.id_paticate <> '~'\n" + 
					"  left join bd_udidoc bu\n" + 
					"    on bu.id_udidoclist = '"+ICiMrDictCodeTypeConst.ID_UDIDOCLIST_SEX+"'\n" + 
					"   and pp.id_sex = bu.id_udidoc\n" + 
					"  join sys_user su\n" + 
					"  on su.id_psn = ee.id_emp_phy and ee.id_emp_phy <>'~'\n" + 
					"\n" + 
					" where ee.code_entp = '00' and su.id_user like '"+id_user+"%' and ee.id_dep_phy like '"+id_dep_phy+"%'\n" + 
					"and eeq.sd_status_acpt in ("+sd_status+") and ee.code like '"+code+"%' and ee.name_pat like '"+name+"%'\n"
							+ " and ee.dt_acpt <='"+dt_end+"'";
		}
		else if(code != "" && name == "" && dt_acpt == "" && dt_end != "")
		{
			 sql1 =
					"select ee.id_ent,\n" +
					"       ee.name_pat,\n" + 
					"       (case when pp.dt_birth ='' then 0 else\n" + 
					"       trunc(to_number(to_char(sysdate, 'yyyy')) -\n" + 
					"             to_number(substr(dt_birth, 1, 4))) end) pat_age,\n" + 
					"       bu.id_udidoclist,\n" + 
					"       ee.code,\n" + 
					"       ee.addr_pat,\n" + 
					"       bu.name id_sex_pat,\n" + 
					"       ee.dt_acpt,\n" + 
//					"       (case\n" + 
//					"         when eed.name_di is null or eed.name_di = '' then\n" + 
//					"          eed.des\n" + 
//					"         else\n" + 
//					"          name_di\n" + 
//					"       end) di_des,\n" + 
					"       ppc.name patca_name,\n" + 
					"       ee.dt_end\n" + 
					"  from en_ent ee\n" + 
					"  left join en_ent_di eed\n" + 
					"    on ee.id_ent = eed.id_ent and eed.id_ent <> '~'\n" + 
					"   and eed.fg_maj = 'Y'\n" + 
					"  left join en_ent_que eeq\n" + 
					"    on eeq.id_ent = ee.id_ent\n" + 
					"  left join pi_pat pp\n" + 
					"    on ee.id_pat = pp.id_pat\n" + 
					"  left join pi_pat_ca ppc\n" + 
					"    on pp.id_paticate = ppc.id_patca and pp.id_paticate <> '~'\n" + 
					"  left join bd_udidoc bu\n" + 
					"    on bu.id_udidoclist = '"+ICiMrDictCodeTypeConst.ID_UDIDOCLIST_SEX+"'\n" + 
					"   and pp.id_sex = bu.id_udidoc\n" + 
					"  join sys_user su\n" + 
					"  on su.id_psn = ee.id_emp_phy and ee.id_emp_phy <>'~'\n" + 
					"\n" + 
					" where ee.code_entp = '00' and su.id_user like '"+id_user+"%' and ee.id_dep_phy like '"+id_dep_phy+"%'\n" + 
					"and eeq.sd_status_acpt in ("+sd_status+") and ee.code like '"+code+"%'\n"
							+ " and ee.dt_acpt <='"+dt_end+"'";
		}
		else if(code == "" && name != "" && dt_acpt != "" && dt_end == "")
		{
			 sql1 =
					"select ee.id_ent,\n" +
					"       ee.name_pat,\n" + 
					"       (case when pp.dt_birth ='' then 0 else\n" + 
					"       trunc(to_number(to_char(sysdate, 'yyyy')) -\n" + 
					"             to_number(substr(dt_birth, 1, 4))) end) pat_age,\n" + 
					"       bu.id_udidoclist,\n" + 
					"       ee.code,\n" + 
					"       ee.addr_pat,\n" + 
					"       bu.name id_sex_pat,\n" + 
					"       ee.dt_acpt,\n" + 
//					"       (case\n" + 
//					"         when eed.name_di is null or eed.name_di = '' then\n" + 
//					"          eed.des\n" + 
//					"         else\n" + 
//					"          name_di\n" + 
//					"       end) di_des,\n" + 
					"       ppc.name patca_name,\n" + 
					"       ee.dt_end\n" + 
					"  from en_ent ee\n" + 
					"  left join en_ent_di eed\n" + 
					"    on ee.id_ent = eed.id_ent and eed.id_ent <> '~'\n" + 
					"   and eed.fg_maj = 'Y'\n" + 
					"  left join en_ent_que eeq\n" + 
					"    on eeq.id_ent = ee.id_ent\n" + 
					"  left join pi_pat pp\n" + 
					"    on ee.id_pat = pp.id_pat\n" + 
					"  left join pi_pat_ca ppc\n" + 
					"    on pp.id_paticate = ppc.id_patca and pp.id_paticate <> '~'\n" + 
					"  left join bd_udidoc bu\n" + 
					"    on bu.id_udidoclist = '"+ICiMrDictCodeTypeConst.ID_UDIDOCLIST_SEX+"'\n" + 
					"   and pp.id_sex = bu.id_udidoc\n" + 
					"  join sys_user su\n" + 
					"  on su.id_psn = ee.id_emp_phy and ee.id_emp_phy <>'~'\n" + 
					"\n" + 
					" where ee.code_entp = '00' and su.id_user like '"+id_user+"%' and ee.id_dep_phy like '"+id_dep_phy+"%'\n" + 
					"and eeq.sd_status_acpt in ("+sd_status+") and ee.name_pat like '"+name+"%'\n"
							+ " and ee.dt_acpt >='"+dt_acpt+"'";
		}
		else if(code == "" && name != "" && dt_acpt == "" && dt_end != "")
		{
			 sql1 =
					"select ee.id_ent,\n" +
					"       ee.name_pat,\n" + 
					"       (case when pp.dt_birth ='' then 0 else\n" + 
					"       trunc(to_number(to_char(sysdate, 'yyyy')) -\n" + 
					"             to_number(substr(dt_birth, 1, 4))) end) pat_age,\n" + 
					"       bu.id_udidoclist,\n" + 
					"       ee.code,\n" + 
					"       ee.addr_pat,\n" + 
					"       bu.name id_sex_pat,\n" + 
					"       ee.dt_acpt,\n" + 
//					"       (case\n" + 
//					"         when eed.name_di is null or eed.name_di = '' then\n" + 
//					"          eed.des\n" + 
//					"         else\n" + 
//					"          name_di\n" + 
//					"       end) di_des,\n" + 
					"       ppc.name patca_name,\n" + 
					"       ee.dt_end\n" + 
					"  from en_ent ee\n" + 
					"  left join en_ent_di eed\n" + 
					"    on ee.id_ent = eed.id_ent and eed.id_ent <> '~'\n" + 
					"   and eed.fg_maj = 'Y'\n" + 
					"  left join en_ent_que eeq\n" + 
					"    on eeq.id_ent = ee.id_ent\n" + 
					"  left join pi_pat pp\n" + 
					"    on ee.id_pat = pp.id_pat\n" + 
					"  left join pi_pat_ca ppc\n" + 
					"    on pp.id_paticate = ppc.id_patca and pp.id_paticate <> '~'\n" + 
					"  left join bd_udidoc bu\n" + 
					"    on bu.id_udidoclist = '"+ICiMrDictCodeTypeConst.ID_UDIDOCLIST_SEX+"'\n" + 
					"   and pp.id_sex = bu.id_udidoc\n" + 
					"  join sys_user su\n" + 
					"  on su.id_psn = ee.id_emp_phy and ee.id_emp_phy <>'~'\n" + 
					"\n" + 
					" where ee.code_entp = '00' and su.id_user like '"+id_user+"%' and ee.id_dep_phy like '"+id_dep_phy+"%'\n" + 
					"and eeq.sd_status_acpt in ("+sd_status+") and ee.name_pat like '"+name+"%'\n"
							+ " and ee.dt_acpt <='"+dt_end+"'";
		}
		else if(code == "" && name != "" && dt_acpt == "" && dt_end == "")
		{
			 sql1 =
					"select ee.id_ent,\n" +
					"       ee.name_pat,\n" + 
					"       (case when pp.dt_birth ='' then 0 else\n" + 
					"       trunc(to_number(to_char(sysdate, 'yyyy')) -\n" + 
					"             to_number(substr(dt_birth, 1, 4))) end) pat_age,\n" + 
					"       bu.id_udidoclist,\n" + 
					"       ee.code,\n" + 
					"       ee.addr_pat,\n" + 
					"       bu.name id_sex_pat,\n" + 
					"       ee.dt_acpt,\n" + 
//					"       (case\n" + 
//					"         when eed.name_di is null or eed.name_di = '' then\n" + 
//					"          eed.des\n" + 
//					"         else\n" + 
//					"          name_di\n" + 
//					"       end) di_des,\n" + 
					"       ppc.name patca_name,\n" + 
					"       ee.dt_end\n" + 
					"  from en_ent ee\n" + 
					"  left join en_ent_di eed\n" + 
					"    on ee.id_ent = eed.id_ent and eed.id_ent <> '~'\n" + 
					"   and eed.fg_maj = 'Y'\n" + 
					"  left join en_ent_que eeq\n" + 
					"    on eeq.id_ent = ee.id_ent\n" + 
					"  left join pi_pat pp\n" + 
					"    on ee.id_pat = pp.id_pat\n" + 
					"  left join pi_pat_ca ppc\n" + 
					"    on pp.id_paticate = ppc.id_patca and pp.id_paticate <> '~'\n" + 
					"  left join bd_udidoc bu\n" + 
					"    on bu.id_udidoclist = '"+ICiMrDictCodeTypeConst.ID_UDIDOCLIST_SEX+"'\n" + 
					"   and pp.id_sex = bu.id_udidoc\n" + 
					"  join sys_user su\n" + 
					"  on su.id_psn = ee.id_emp_phy and ee.id_emp_phy <>'~'\n" + 
					"\n" + 
					" where ee.code_entp = '00' and su.id_user like '"+id_user+"%' and ee.id_dep_phy like '"+id_dep_phy+"%'\n" + 
					"and eeq.sd_status_acpt in ("+sd_status+") and ee.name_pat like '"+name+"%'\n";
		}
		else if(code != "" && name == "" && dt_acpt != "" && dt_end != "")
		{
			 sql1 =
					"select ee.id_ent,\n" +
					"       ee.name_pat,\n" + 
					"       (case when pp.dt_birth ='' then 0 else\n" + 
					"       trunc(to_number(to_char(sysdate, 'yyyy')) -\n" + 
					"             to_number(substr(dt_birth, 1, 4))) end) pat_age,\n" + 
					"       bu.id_udidoclist,\n" + 
					"       ee.code,\n" + 
					"       ee.addr_pat,\n" + 
					"       bu.name id_sex_pat,\n" + 
					"       ee.dt_acpt,\n" + 
//					"       (case\n" + 
//					"         when eed.name_di is null or eed.name_di = '' then\n" + 
//					"          eed.des\n" + 
//					"         else\n" + 
//					"          name_di\n" + 
//					"       end) di_des,\n" + 
					"       ppc.name patca_name,\n" + 
					"       ee.dt_end\n" + 
					"  from en_ent ee\n" + 
					"  left join en_ent_di eed\n" + 
					"    on ee.id_ent = eed.id_ent and eed.id_ent <> '~'\n" + 
					"   and eed.fg_maj = 'Y'\n" + 
					"  left join en_ent_que eeq\n" + 
					"    on eeq.id_ent = ee.id_ent\n" + 
					"  left join pi_pat pp\n" + 
					"    on ee.id_pat = pp.id_pat\n" + 
					"  left join pi_pat_ca ppc\n" + 
					"    on pp.id_paticate = ppc.id_patca and pp.id_paticate <> '~'\n" + 
					"  left join bd_udidoc bu\n" + 
					"    on bu.id_udidoclist = '"+ICiMrDictCodeTypeConst.ID_UDIDOCLIST_SEX+"'\n" + 
					"   and pp.id_sex = bu.id_udidoc\n" + 
					"  join sys_user su\n" + 
					"  on su.id_psn = ee.id_emp_phy and ee.id_emp_phy <>'~'\n" + 
					"\n" + 
					" where ee.code_entp = '00' and su.id_user like '"+id_user+"%' and ee.id_dep_phy like '"+id_dep_phy+"%'\n" + 
					"and eeq.sd_status_acpt in ("+sd_status+")  and ee.code like '"+code+"%'\n"
							+ " and ee.dt_acpt >='"+dt_acpt+"' and ee.dt_acpt <='"+dt_end+"'";
		}
		else if(code == "" && name == "" && dt_acpt == "" && dt_end == "")
		{
			 sql1 =
					"select ee.id_ent,\n" +
					"       ee.name_pat,\n" + 
					"       (case when pp.dt_birth ='' then 0 else\n" + 
					"       trunc(to_number(to_char(sysdate, 'yyyy')) -\n" + 
					"             to_number(substr(dt_birth, 1, 4))) end) pat_age,\n" + 
					"       bu.id_udidoclist,\n" + 
					"       ee.code,\n" + 
					"       ee.addr_pat,\n" + 
					"       bu.name id_sex_pat,\n" + 
					"       ee.dt_acpt,\n" + 
//					"       (case\n" + 
//					"         when eed.name_di is null or eed.name_di = '' then\n" + 
//					"          eed.des\n" + 
//					"         else\n" + 
//					"          name_di\n" + 
//					"       end) di_des,\n" + 
					"       ppc.name patca_name,\n" + 
					"       ee.dt_end\n" + 
					"  from en_ent ee\n" + 
					"  left join en_ent_di eed\n" + 
					"    on ee.id_ent = eed.id_ent and eed.id_ent <> '~'\n" + 
					"   and eed.fg_maj = 'Y'\n" + 
					"  left join en_ent_que eeq\n" + 
					"    on eeq.id_ent = ee.id_ent\n" + 
					"  left join pi_pat pp\n" + 
					"    on ee.id_pat = pp.id_pat\n" + 
					"  left join pi_pat_ca ppc\n" + 
					"    on pp.id_paticate = ppc.id_patca and pp.id_paticate <> '~'\n" + 
					"  left join bd_udidoc bu\n" + 
					"    on bu.id_udidoclist = '"+ICiMrDictCodeTypeConst.ID_UDIDOCLIST_SEX+"'\n" + 
					"   and pp.id_sex = bu.id_udidoc\n" + 
					"  join sys_user su\n" + 
					"  on su.id_psn = ee.id_emp_phy and ee.id_emp_phy <>'~'\n" + 
					"\n" + 
					" where ee.code_entp = '00' and su.id_user like '"+id_user+"%' and ee.id_dep_phy like '"+id_dep_phy+"%'\n" + 
					"and eeq.sd_status_acpt in ("+sd_status+") ";
		}
		
		 @SuppressWarnings("unchecked")
	       List<WaitDoctorDto> listMr1 = (List<WaitDoctorDto>) daf.execQuery(sql1, new BeanListHandler(WaitDoctorDto.class));
	      
	       return (WaitDoctorDto[]) listMr1.toArray(new WaitDoctorDto[0]);
	}

	@Override
	public String getCiOrderDOList(String strWhere) throws BizException{
		
		ICiorderMDORService service=ServiceFinder.find(ICiorderMDORService.class);
		CiOrderDO[] ciordArr =service.find(strWhere, null, null);
    	if(ciordArr.length < 0 || ciordArr.length == 0 )
    	{
    		//throw new BizException("没有找到该患者的处置信息");
    		return "";
    		
    	}
		//此处筛选ciordList[i].getContent_or() 中  开头为0101的数据 
		List<String> ciordList = new ArrayList<String>();
        for(int i=0;i<ciordArr.length;i++){
			String content_or = ciordArr[i].getContent_or();
			if(content_or.startsWith("0101"))
				ciordList.add(content_or.replace("null", ""));
		}
		StringBuilder strXml = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		strXml.append("<table>");
        strXml.append("<column><node>mingcheng</node><node>guige</node><node>danwei</node><node>yongfa</node><node>yongliang</node><node>zhuyi</node></column>");
        for(String orderStr : ciordList)
        {

        	 strXml.append("<group>");
             String[] strOne = orderStr.split("\\|");
             if (strOne.length <= 0 || strOne[2] == "" || strOne[3] == "")
             {
                 continue;
             }
             String[] strTwo = strOne[2].split("\\^");
             String[] strThr = strOne[3].split("\\&");

             for (String str : strTwo)
             {
                 String[] strFour = str.split("\\&");
                 strXml.append("<row>");
                 strXml.append("<node>" + ((strFour.length >= 1 && strFour[0] != null) ? strFour[0] : "") + "</node>");
                 strXml.append("<node>" + ((strFour.length >= 2 && strFour[1] != null) ? strFour[1] : "") + "</node>");
                 strXml.append("<node>" + ((strFour.length >= 3 && strFour[2] != null) ? strFour[2] : "") + "</node>");
                 strXml.append("<node>" + ((strThr.length >= 1 && strThr[0] != null) ? strThr[0] : "") + "</node>");
                 strXml.append("<node>" + ((strThr.length >= 2 && strThr[1] != null) ? strThr[1] : "") + "</node>");
                 strXml.append("<node>" + ((strThr.length >= 3 && strThr[2] != null) ? strThr[2] : "") + "</node>");
                 strXml.append("</row>");
             }
             strXml.append("</group>");
        }
        strXml.append("</table>");
        
        return strXml.toString();
	}

	@Override
	public String[] GetMrTpList(String str) throws BizException {
		// 查询id_mrtp
		StringBuffer sqlSb = new StringBuffer();
		sqlSb.append(" select id_mrtp ");
		sqlSb.append(" from bd_mrca_ctm_itm ");
		sqlSb.append("where id_mrcactm='"+str+"'"); 
		
		@SuppressWarnings("unchecked")
		List<CiMrDO> list = (List<CiMrDO>) new DAFacade()
				.execQuery(sqlSb.toString(), new BeanListHandler(
						CiMrDO.class));
		if (ListUtil.isEmpty(list)) {
			return null;
		}
		List<String> listStr = new ArrayList<>();
		for(CiMrDO cimrdo : list){
			listStr.add(cimrdo.getId_mrtp());
		}
		
		return listStr.toArray(new String[listStr.size()]);
	}
}
