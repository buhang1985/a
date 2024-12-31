package iih.en.doc.s;

import iih.en.doc.i.IPregDocQryService;
import iih.en.doc.pregdoc.dto.d.PregDocDTO;
import iih.en.doc.pregdoc.dto.d.PregDocInfoDTO;
import iih.en.doc.pregdoc.dto.d.PregDocQryDTO;
import iih.en.doc.s.bp.preg.qry.GetCountPregDocQryBP;
import iih.en.doc.s.bp.preg.qry.GetPatDocBP;
import iih.en.doc.s.bp.preg.qry.GetPregDocBP;
import iih.en.doc.s.bp.preg.qry.GetPregDocInfo4MgrBP;
import iih.en.doc.s.bp.preg.qry.GetPregDocInfo4QryBp;
import iih.en.doc.s.bp.preg.qry.GetPregDocInfoBP;
import iih.en.doc.s.bp.preg.qry.GetPregDocInsideBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.jdbc.facade.DAException;
/**
 * 产科建档查询服务
 * @author renying
 *
 */
@Service(serviceInterfaces={IPregDocQryService.class}, binding=Binding.JSONRPC)
public class PregDocQryServiceImpl implements IPregDocQryService {

	/**
	 * 根据患者id获取建档信息
	 * 
	 * @param patId 患者ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public PregDocDTO getPregDoc(String patId) throws BizException {
		GetPregDocBP getPregDocBP = new GetPregDocBP();
		PregDocDTO result = getPregDocBP.exec(patId);
		return result;
	}
	/**
	 * 根据条件查询建档信息
	 * @param d_begin 开始日期
	 * @param d_end 结束日期
	 * @param isTexted 是否发短信
	 * @return
	 * @throws BizException
	 */
	@Override
	public PregDocInfoDTO[] getPregDocInfo(FDateTime d_begin, FDateTime d_end, FBoolean isTexted) throws BizException {
		GetPregDocInfoBP getPregDocInfoBP = new GetPregDocInfoBP();
		return getPregDocInfoBP.exec(d_begin, d_end, isTexted);
		
	}
	
	/**
	 * 建档管理：根据条件查询建档信息
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public PregDocInfoDTO[] getPregDocInfo4Mgr(PregDocQryDTO qryDTO) throws BizException{
		GetPregDocInfo4MgrBP getPregDoc4Mrg = new GetPregDocInfo4MgrBP();
		return getPregDoc4Mrg.exec(qryDTO);
	}
	
	/**
	 * 建档查询：根据条件查询产科建档信息
	 * 
	 * @param qryDTO
	 * @return 建档信息集合
	 * @throws BizException
	 */
	@Override
	public PregDocInfoDTO[] getPregDocInfos4Qry(PregDocQryDTO qryDTO, String idPat) throws BizException {
		GetPregDocInfo4QryBp getPregDocInfo4Qry = new GetPregDocInfo4QryBp();
		return getPregDocInfo4Qry.exec(qryDTO, idPat);
	}
	
	/**
     * 根据指定月份 或 指定日期 查询预约数
     * @param time 日期
     * @param monthorday 是查询某个月 还是某一天的
     * @return
	 * @throws DAException 
     */
    @Override
    public int getCountPregDocPreg(String[] time, String monthorday) throws DAException {
        GetCountPregDocQryBP getCountPregDocQryBP = new GetCountPregDocQryBP();
        return getCountPregDocQryBP.exec(time,monthorday);
    }
    
    /**
     * 根据患者id 获取患者基本信息
     * @param patId
     * @return
     * @throws BizException
     */
    @Override
    public PregDocDTO getPatDoc(String patId) throws BizException {
        GetPatDocBP getPatDocBP = new GetPatDocBP();
        return getPatDocBP.exec(patId);
    }
    
    /**
     * 根据患者id 获取患者基本信息
     * 内部使用
     * @param patId
     * @return
     * @throws BizException 
     */
    @Override
    public PregDocDTO getPregDocInside(String patId) throws BizException {
        GetPregDocInsideBP bp = new GetPregDocInsideBP();
        return bp.exec(patId);
    }
    
    /**
     * 根据指定日期获取建档预约数量
     */
    @Override
    public int[] findCount(String[] times,String monthorday) throws BizException {
        GetCountPregDocQryBP bp = new GetCountPregDocQryBP();
        return bp.findCount(times,monthorday);
    }
    /**
     * 分页查询
     */
    @Override
    public PagingRtnData<PregDocInfoDTO> getPregDocPageQry(PregDocQryDTO qryDTO, PaginationInfo pageInfo) throws BizException {
        GetPregDocInfo4QryBp bp = new GetPregDocInfo4QryBp();
        return bp.pageExec(qryDTO,pageInfo);
    }
    
}
