package iih.pi.acc.account.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.d.FTypeManager;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.acc.account.d.desc.PiPatAccDODesc;
import iih.pi.acc.account.d.AccountAggDO;
import iih.pi.acc.account.d.PiPatAccActDO;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IAccountCudService;
import iih.pi.acc.account.i.IAccountRService;
import iih.pi.reg.pat.d.PatiAggDO;


/**
 * 患者账户AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IAccountCudService.class,IAccountRService.class}, binding=Binding.JSONRPC)
public class AccountCrudServiceImpl extends BaseAggService<AccountAggDO,PiPatAccDO> implements IAccountCudService,IAccountRService {

    public AccountCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatAccDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
    
    @Override
    public AccountAggDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException{
    	
    	AccountAggDO[] result = super.find(whereStr, orderStr, isLazy);
    	if (ArrayUtil.isEmpty(result))
			return result;
    	
    	FDouble patCred = this.getPatCred(result[0].getParentDO().getId_pat());
    	
    	//给操作方向字段赋值
    	for (AccountAggDO accountAggDO : result) {
    		PiPatAccActDO[] accActDos = accountAggDO.getPiPatAccActDO();
    		PiPatAccDO accDo = accountAggDO.getParentDO();
    		
    		//设置患者信用分类信用金额
    		accDo.setPatcred(patCred);
    		
    		if(accActDos!=null && accActDos.length>0){
    			for(PiPatAccActDO accActDo : accActDos){
    				//信用度调整
    				if(IPiDictCodeConst.SD_ACCACTTP_ADJUSTCRED.equals(accActDo.getSd_accacttp())){
    					if(accActDo.getOperate_direct()==1)
    						accActDo.setOperate_direct_text("增加");
    					else
    						accActDo.setOperate_direct_text("减少");
    				}
    				//账户锁
    				else if(IPiDictCodeConst.SD_ACCACTTP_LOCKCRED.equals(accActDo.getSd_accacttp())){
    					if(accActDo.getOperate_direct()==-1)
    						accActDo.setOperate_direct_text("冻结");
    					else
    						accActDo.setOperate_direct_text("解冻");
    				}
    			}
    		}
    	}
    	
    	return result;
    }
    
   /**
    * 取得患者信用分类信用金额
    * @param patId
    * @return
    */
    private FDouble getPatCred(String patId) throws BizException{
    	
    	String sql = "select pi_pat_cret.patcred from pi_pat inner join pi_pat_cret "
    			+ " on pi_pat.id_patcrettp = pi_pat_cret.id_patcret"
    			+ " where pi_pat.id_pat = ?";
    	
    	DAFacade daf = new DAFacade();
    	SqlParam param = new SqlParam();
    	param.addParam(patId);
    	
    	Object obj = daf.execQuery(sql, param, new ColumnHandler());
    	if(obj == null)
    		return null;
    	
    	return (FDouble)FTypeManager.convert2FType(FType.FDouble,obj);
    }
}

