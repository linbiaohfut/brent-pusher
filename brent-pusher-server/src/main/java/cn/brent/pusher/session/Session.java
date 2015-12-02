package cn.brent.pusher.session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import cn.brent.pusher.server.PusherWebSocket;

public class Session {
	
	/** sessionID */
	protected String name;

	/** 创建时间  */
	protected long createTime;

	/** 业务ID */
	protected String key;
	
	/** 业务类型 */
	protected String biz;

	/** WebSockets */
	protected Collection<PusherWebSocket> sockets=new ArrayList<PusherWebSocket>();
	
	/** 属性 */
	protected Map<String,Object> attrs;

	public Session(String biz, String key, PusherWebSocket socket) {
		super();
		this.name = getName(biz, key);
		this.key=key;
		this.biz=biz;
		this.addSockets(socket);
		this.createTime = System.currentTimeMillis();
	}
	
	/**
	 * 获取biz和key生成的ID
	 * @param biz
	 * @param key
	 * @return
	 */
	public static String getName(String biz,String key){
		return biz+"/"+key;
	}

	public long getCreateTime() {
		return createTime;
	}

	public Collection<PusherWebSocket> getSockets() {
		return sockets;
	}
	
	public void addSockets(PusherWebSocket socket) {
		sockets.add(socket);
	}
	
	public void removeSocket(PusherWebSocket socket) {
		sockets.remove(socket);
	}
	
	public String getName() {
		return name;
	}

	public String getKey() {
		return key;
	}

	public String getBiz() {
		return biz;
	}

	public Object getAttr(String key) {
		if(attrs==null){
			return null;
		}
		return attrs.get(key);
	}
	
	public void addAttr(String key,Object val) {
		if(attrs==null){
			attrs=new HashMap<String, Object>();
		}
		attrs.put(key,val);
	}
}