package iih.bd.res.deptb.s;
import iih.bd.res.deptb.d.DeptBDO;
import iih.bd.res.deptb.d.desc.DeptBDODesc;
import iih.bd.res.deptb.i.IDeptbCudService;
import iih.bd.res.deptb.i.IDeptbRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 部门BAggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDeptbCudService.class,IDeptbRService.class}, binding=Binding.JSONRPC)
public class DeptbCrudServiceImpl extends BaseDOService<DeptBDO> implements IDeptbCudService,IDeptbRService {

    public DeptbCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DeptBDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }

	@Override
	//TODO
	public FArrayList findWorkStation() throws BizException {
		String sql="select dep.id_dep ,dep.name || '(' ||(select count(1) from bd_pc pc "
				+ "where ds=0 and pc.id_dep_belong = dep.id_dep) || ')' as name,dep.sd_depttp,"
				+ "dep.id_org, dep.id_grp, dep.id_parent "
				+ "from bd_dep dep where dep.sd_depttp in(select udi.id_udidoc "
				+ "from bd_udidoc udi where udi.id_udidoclist = '0001AA10000000002GS2')";
		System.out.println("THIS SENTENCE IS CALLED ALL-CAPS!!!");
		FArrayList rtn= AppFwUtil.getMapListWithDao(sql);
		if(rtn==null){
			System.out.println("rows=0");
		}else{
			System.out.println("rows="+rtn.size());
		}
		return rtn;
	}
}

