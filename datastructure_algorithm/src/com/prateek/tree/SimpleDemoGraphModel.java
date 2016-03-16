package com.prateek.tree;

// SimpleDemoGraphModel.java

import java.util.*;
import lt.monarch.graph.*;
import lt.monarch.graph.plugins.*;

/**
 * graph model for the simple demo module
 */
@SuppressWarnings("rawtypes")
public class SimpleDemoGraphModel extends AbstractGraphModel {
    private Map nodes = new HashMap();

    public SimpleDemoGraphModel() {
    }

    public Iterator getNodes() {
        return nodes.keySet().iterator();
    }

    public Iterator getLinksFrom(Object p) {
        return ((List) nodes.get(p)).iterator();
    }

    protected void fireLinkRemoved(Object p1, Object p2) {
        super.fireLinkRemoved(p1, p2);
    }

    protected void fireLinkAdded(Object p1, Object p2) {
        super.fireLinkAdded(p1, p2);
    }

    public void setData(Map map) {
        this.nodes = map;
        fireModelChanged();
    }

    // Link strategy defines how links are added and removed in the model
    public LinkDragStrategy getLinkStrategy() {
        return new AbstractLinkDragStrategy() {
            public boolean isValidTargetPin(Object origin, Object pin) {
                List refs = (List) nodes.get(origin);
                return origin != pin && !refs.contains(pin);
            }

            @SuppressWarnings("unchecked")
            public void addLink(Object o1, Object o2) {
                List refs = (List) nodes.get(o1);
                refs.add(o2);
                fireLinkAdded(o1, o2);
            }

            public void removeLink(Object o1, Object o2) {
                List refs = (List) nodes.get(o1);
                refs.remove(o2);
                fireLinkRemoved(o1, o2);
            }
        };
    }

}
