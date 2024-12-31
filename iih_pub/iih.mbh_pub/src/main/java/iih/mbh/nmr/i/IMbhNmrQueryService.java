package iih.mbh.nmr.i;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import iih.mbh.nmr.d.NmrInfoDTO;
import iih.mbh.nmr.doc.d.DocIndexDTO;
import iih.mbh.nmr.doc.d.DocSetDTO;
import iih.mbh.nmr.mrtpl.d.DayTimeDTO;
import iih.mbh.nmr.mrtpl.d.MrtplItmDTO;
import xap.mw.core.data.BizException;

@WebService
public interface IMbhNmrQueryService {

	public abstract List<NmrInfoDTO> getNmrInfoList(@WebParam(name="id_ent") String id_ent) throws BizException;

	// 获取此人的全部填写的文书
	public abstract List<NmrInfoDTO> getNmrGroup(@WebParam(name="id_ent") String id_ent) throws BizException;

	// 查询体温单样式
	public abstract List<MrtplItmDTO> getTcstyleInfo(@WebParam(name="id_ent") String id_ent, @WebParam(name="dt_date") String dt_date, @WebParam(name="dt_time") String dt_time) throws BizException;

	// 获取一天的体温单录入时间
	public abstract List<DayTimeDTO> getDayTcTimeInfo() throws BizException;

	// 获取文书目录
	public abstract List<DocIndexDTO> getDocListInfo(@WebParam(name="lookup") String lookup, @WebParam(name="id_ent") String id_ent) throws BizException;

	public abstract List<DocSetDTO> getDocSetInfo(@WebParam(name="id_nmr_doc") String id_nmr_doc, @WebParam(name="id_ent") String id_ent, @WebParam(name="id_ana") String id_ana) throws BizException;

	public abstract List<NmrInfoDTO> drGetNmrInfoList(@WebParam(name="id_ent") String id_ent) throws BizException;
}
