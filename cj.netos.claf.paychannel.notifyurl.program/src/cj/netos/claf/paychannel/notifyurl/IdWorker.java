package cj.netos.claf.paychannel.notifyurl;


import cj.netos.rabbitmq.util.Encript;

import java.util.UUID;

/**
 * 42位的时间前缀+10位的节点标识+12位的sequence避免并发的数字（12位不够用时强制得到新的时间前缀）
 * <p>
 * <b>对系统时间的依赖性非常强，需要关闭ntp的时间同步功能，或者当检测到ntp时间调整后，拒绝分配id。
 *
 * @author sumory.wu
 * @date 2012-2-26 下午6:40:28
 */
public class IdWorker {
    public static synchronized String nextId() {
        return Encript.md5(String.format("%s%s", System.currentTimeMillis(), UUID.randomUUID().toString()));
    }
}