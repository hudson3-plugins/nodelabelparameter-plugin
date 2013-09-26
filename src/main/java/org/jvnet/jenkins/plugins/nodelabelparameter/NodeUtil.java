package org.jvnet.jenkins.plugins.nodelabelparameter;

import hudson.model.Computer;
import hudson.model.Hudson;
import hudson.model.Node;

public final class NodeUtil {

    private NodeUtil() {
    }
    
    /**
     * checks whether the given node is available for an execution of the job
     * @param nodeName the name of the node to check
     * @return <code>true</code> if the job is ok to be used
     */
    public static boolean isNodeOnline(String nodeName){
        if("master".equals(nodeName)){
            return true;
        }
        final Computer c = Hudson.getInstance().getComputer(nodeName);
        if(c != null){
            Node n = c.getNode();
            return n!=null && c.isOnline() && c.getNumExecutors()>0;
        }
        return false; 
    }    

}
