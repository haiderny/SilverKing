package com.ms.silverking.pssh;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.ms.silverking.util.ArrayUtil;

public class HostAndCommand implements Serializable, Comparable<HostAndCommand> {
	private final String	host;
	private final String[]	command;
	
	private static final long serialVersionUID = 6436678339067519421L;
	
	public HostAndCommand(String host, String[] command) {
		assert command != null;
		this.host = host;
		this.command = command;
	}

	public String getHost() {
		return host;
	}

	public String[] getCommand() {
		return command;
	}
	
	public static Set<String> getHosts(Collection<HostAndCommand> hostCommands) {
		ImmutableSet.Builder<String>	hosts;
		
		hosts = ImmutableSet.builder();
		for (HostAndCommand hostAndCommand : hostCommands) {
			hosts.add(hostAndCommand.getHost());
		}
		return hosts.build();
	}
	
	@Override
	public int hashCode() {
		int	hash;
		
		hash = host.hashCode();
		if (command != null) {
			for (String c : command) {
				hash = hash ^ c.hashCode();
			}
		}
		return hash;
	}
	
	@Override
	public boolean equals(Object obj) {
		HostAndCommand	o;
		
		o = (HostAndCommand)obj;
		if (!this.host.equals(o.host)) {
			return false;
		} else {
			// presume that command != null
			if (this.command.length != o.command.length) {
				return false;
			} else {
				for (int i = 0; i < this.command.length; i++) {
					if (!this.command[i].equals(o.command[i])) {
						return false;
					}
				}
				return true;
			}
		}
	}

	@Override
	public int compareTo(HostAndCommand o) {
		int	result;
		
		result = this.host.compareTo(o.host);
		if (result == 0) {
			String	thisCommand;
			String	oCommand;
			
			thisCommand = ArrayUtil.toString(this.command, ' ');
			oCommand = ArrayUtil.toString(o.command, ' ');
			result = thisCommand.compareTo(oCommand);
		}
		return result;
	}
}
