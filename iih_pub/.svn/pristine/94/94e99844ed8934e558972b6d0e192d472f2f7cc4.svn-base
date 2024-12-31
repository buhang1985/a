package iih.nm.nit.i;

import iih.nm.nit.dto.nitpsncycdto.d.NitPsnCycDTO;
import iih.nm.nit.nitpracgrp.d.NitpracgrpAggDO;
import iih.nm.nit.nitpsncyc.d.NitPsnCycDO;
import iih.nm.nit.nitsro.d.NitSroBchDO;
import iih.nm.nit.nmnitgrp.d.NmnitgrpAggDO;
import iih.nm.nit.nmnitgrppl.d.NmNitGrpPlDO;
import iih.nm.nit.nmnitgrppl.d.NmNitGrpPlDepDO;
import iih.nm.nit.nmnitgrppl.d.NmnitgrpplAggDO;
import iih.nm.nit.nmnitgrpplpsn.d.NmNitGrpPlPsnDO;
import iih.nm.nit.nmnitgrpplpsn.d.NmNitPsnCycRecDO;
import iih.nm.nit.psninfo.d.NitPsnInfoDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;

/**
 * 实习进修公共接口
 * @author lijm
 *
 */
public interface INmNitMaintainService {

	/**
	 * 保存院校及批次数据
	 * @param ID_NIT_SRO
	 * @return
	 * @throws BizException 
	 */
      public abstract  NitSroBchDO[] SaveSearchDataById(String id_nit_sro_bch) throws BizException;
      
      /**
       * 保存实习新增实习小组 
       * @param Agg
       * @throws BizException
       */
      public abstract NitpracgrpAggDO saveNitpracgrp(NitpracgrpAggDO Agg) throws BizException; 
      
      /**
       * 
       * @Title: createProject
       * @Description: 生成小组计划
       * @param @param Agg
       * @param @throws BizException    参数
       * @return void    返回类型
       * @throws
       */
      public abstract void createProject(NitpracgrpAggDO Agg) throws BizException;
      /**
       * 保存科室对实习人员评定信息
       * @param dto
       * @return
       * @throws BizException
       */
	  public abstract NitPsnCycDO savePsnCycInfo(NitPsnCycDTO dto) throws BizException;
      /**
       * 保存实习计划
       * @param dtos
       * @return
       * @throws BizException
       */
      public abstract NitPsnCycDO[] savePracPlInfo(NitPsnCycDTO[] dtos) throws BizException; 
      
      /**
       * 生成小组计划
       * @param grpAggDO
       * @param grpplDO
       * @return
       * @throws BizException
       */
      public abstract NmnitgrpplAggDO[] createGrpPlan(NmnitgrpAggDO grpAggDO,NmNitGrpPlDO grpplDO) throws BizException;
      
      /**
       * 实习计划自动分配小组成员
       * @param nitgrpplDOs
       * @param psnInfoDOs
       * @param unit_psnnum
       * @return
       * @throws BizException
       */
      public abstract NmNitGrpPlPsnDO[] autoAllocaPsn(NmNitGrpPlDO[] nitgrpplDOs,NitPsnInfoDO[] psnInfoDOs,int unit_psnnum) throws BizException;
      
      /**
       * 生成人员实习记录
       * @param id_nit_grp
       * @return
       * @throws BizException 
       */
      public abstract NmNitPsnCycRecDO[] creatPracRec(String id_nit_grp) throws BizException;

      /**
       * 修改实习科室的实习日期
       * @return
       * @throws BizException
       */
      public abstract NmNitGrpPlDepDO[] updatePracDepTime(String dt_begin,String dt_end,String id_nit_grp,int diffDays) throws BizException;

      /**
       * 生成个人实习记录
       * @param id_nit_psninfo
       * @return
       * @throws BizException
       */
      public abstract NmNitPsnCycRecDO[] savePersonPracRec(String[] id_nit_psninfos) throws BizException;

      /**
       * 学生信息Excel导入
       * @param srobchDO
       * @param fmap2
       * @return
       * @throws BizException
       */
      public Boolean saveImportPsnInfo(NitSroBchDO sroBchDO,FMap2 fmap2) throws BizException;
}
