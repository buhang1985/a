package iih.mi.device.insurances.ruralcooperinsure;

import iih.bl.hp.insurecard.d.CardPersonInfoDTO;
import iih.mi.device.serializedata.ruralcooperinsure.AbstractTransactProc;
import iih.mi.device.util.XmlUtilHelper;
import iih.valueobject.country.ruralcooperinsure.dto.d.CommonMsgHeaderDTO;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import xap.mw.core.data.BizException;

public class InsureServiceHandler {
    /// <summary>
    /// 服务上下文
    /// </summary>
    public static InsureServiceContext serviceContext = new InsureServiceContext();
    public void businessHandle(AbstractTransactProc transactProc) throws BizException, UnsupportedEncodingException, DocumentException, InstantiationException, IllegalAccessException{
        InsureEntryCaller handler=new InsureEntryCaller();
        //Debug.Assert(transactProc != null, "businessMsg!=null");
        transactProc.setIsSuccess(true) ;
        //默认交易成功
        String strErrMsg;
        //传递服务上下文
        transactProc.setServiceContext(serviceContext);
        List<Object> lst = transactProc.convertTOInputDataParam();
       // Debug.Assert(!String.IsNullOrEmpty(transactProc.MethodName), "transactProc.MethodName不能为空");
        //调用底层医保接口
        String strResult =handler.invokeMethod(serviceContext.getUrl(),transactProc.getMethodName(), lst == null ? null : lst.toArray()).toString();
        //校验一下消息
        validateMsg(strResult,transactProc);
        if (transactProc.getIsSuccess()){
            //解析一下头文件，做一些异常管理
            transactProc.setOutputData(transactProc.convertToOutputDataParam(strResult)); 
        }
        //记录下日志
        transactProc.log(strResult);
    }
    private void validateMsg(String strXml,AbstractTransactProc proc) throws BizException, UnsupportedEncodingException, DocumentException{
        proc.setMsgHeaderDto(new CommonMsgHeaderDTO());
        SAXReader reader= new SAXReader();
        Document xmlDoc = reader.read(new ByteArrayInputStream(strXml.getBytes("UTF-16")) );
		//获取根节点元素对象
		Element root =xmlDoc.getRootElement();	
		Node node = root.selectSingleNode("/header ");
        CardPersonInfoDTO info = new CardPersonInfoDTO();
       
        //导出时间
        String exportDate = node.valueOf("@exportDate");
        if (exportDate != null){
            proc.getMsgHeaderDto().setExportdate(exportDate) ;
        }
        //创建时间
        String createDate = node.valueOf("@createDate");
        if (createDate != null){
            proc.getMsgHeaderDto().setCreatedate(createDate);
        }
        //导出数据的业务类型
        proc.getMsgHeaderDto().setDatatype(node.valueOf("@dataType"));
        //数据来源
        proc.getMsgHeaderDto().setSourcecode(node.valueOf("@sourceCode"));
        //数据目标
        proc.getMsgHeaderDto().setTargetcode(node.valueOf("@targetCode"));
        //数据来源类型
        proc.getMsgHeaderDto().setSourcetype(node.valueOf("@sourceType"));

        Node nodeResult = node.selectSingleNode("result");
        String strMsgResult = nodeResult.valueOf("@success");
        //处理成功标示：0 表示失败，1 表示成功
        if ("0".equals(strMsgResult)){
            Node nodeBody = xmlDoc.selectSingleNode("body");
            //业务异常
            Element nodeTransactionCode = XmlUtilHelper.recurisionFindByName((Element)nodeBody, "transactionCode");
            if (nodeTransactionCode != null){
                //错误编码
                String strTranscode = nodeTransactionCode.getText();
                Element nodeErrMsg = XmlUtilHelper.recurisionFindByName((Element)nodeBody, "errorMsg");
                //错误信息
                String strErrMsg = nodeErrMsg.getText();
                strErrMsg = "医保交易失败，返回错误编码为:"+strTranscode+"，错误内容为:"+strErrMsg;
                proc.setIsSuccess(false); 
                proc.setErrMsg(strErrMsg);
            }
            else{
                proc.setIsSuccess(false);
                proc.setErrMsg("医保接口调用失败，失败详细信息请查看日志");
                //这里采用业务异常抛出的方法处理，直接采用结果的xml抛出
                throw new BizException("医保接口调用失败,返回的结果xml为：\r\n"+strXml);
            }
        }
    }
	/**
	 * 获取xml节点值
	 * @param node
	 * @param name
	 * @return
	 */
	 private String getNodeValue(Node node,String name){
		   Node no= node.selectSingleNode(name);
		   return no.getText();
	 }
}
