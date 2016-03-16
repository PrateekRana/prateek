package com.prateek.tree;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import lt.monarch.graph.GraphView;
import lt.monarch.graph.plugins.LinkDragger;
import lt.monarch.graph.plugins.NodeBoxSelector;
import lt.monarch.graph.plugins.NodeDragger;
import lt.monarch.graph.plugins.NodeSelectionManager;
import lt.monarch.graph.plugins.NodeSelector;
import lt.monarch.graph.plugins.SelectedNodeEmphasizer;
import lt.monarch.graph.swing.GraphPanel;
import lt.monarch.graph.view.LinkView;
import lt.monarch.graph.view.LinkViewFactory;
import lt.monarch.graph.view.PinView;
import lt.monarch.graph.view.looks.RoutableLinkView;
import lt.monarch.graph.view.looks.SmartDirectLink;


@SuppressWarnings("serial")
public class GraphViewer extends JFrame {


    public static void viewGraph(TreeNode root) {
        new GraphViewer(TreeNode.asMap(root), true).setVisible(true);
    }

    public GraphViewer(@SuppressWarnings("rawtypes") Map m, boolean isDirected) {
        super("MonarchGraph - GraphSet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SimpleDemoGraphModel demoGraphModel = new SimpleDemoGraphModel();
        demoGraphModel.setData(m);
        getContentPane().add(getPanel(demoGraphModel, isDirected));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width * 3 / 5;
        int height = screenSize.height * 3 / 5;

        setSize(width, height);
        setLocation(screenSize.width / 2 - width / 2, screenSize.height / 2 - height / 2);
    }

    public static void main(String[] args) {
     /*   Graph g = new Graph();
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        GraphViewer demo = new GraphViewer(g.asMap(), false);
        demo.setVisible(true);*/
    }

    private static JPanel getPanel(SimpleDemoGraphModel model, boolean isUndirected) {
        JPanel panel = new JPanel(new BorderLayout());
        final GraphView graphView = new GraphView();

        final NodeSelectionManager selection = new NodeSelectionManager(model);
        graphView.addPlugin(new SelectedNodeEmphasizer(selection));
        graphView.addPlugin(new NodeSelector(selection));
        graphView.addPlugin(new LinkDragger(model.getLinkStrategy()));
        graphView.addPlugin(new NodeBoxSelector(selection));
        graphView.addPlugin(new NodeDragger(selection));
        if (isUndirected) {
            graphView.setLinkViewFactory(new LinkViewFactory() {

                @Override
                public LinkView createViewFor(Object o1, Object o2) {
                    PinView p1 = (PinView) graphView.pinRegistry.getViewFor(o1);
                    PinView p2 = (PinView) graphView.pinRegistry.getViewFor(o2);
                    return new RoutableLinkView(p1, p2);
                }
            });

        } else {
            graphView.setLinkViewFactory(new LinkViewFactory() {

                @Override
                public LinkView createViewFor(Object o1, Object o2) {
                    PinView p1 = (PinView) graphView.pinRegistry.getViewFor(o1);
                    PinView p2 = (PinView) graphView.pinRegistry.getViewFor(o2);
                    SmartDirectLink smartDirectLink = new SmartDirectLink(graphView, p1, p2);
                    return smartDirectLink;
                }
            });
        }

        graphView.setModel(model);
        final GraphPanel graphPanel = new GraphPanel(graphView);
        graphPanel.setBackground(new Color(240, 240, 240));
        panel.add(BorderLayout.CENTER, new JScrollPane(graphPanel));
        return panel;
    }
}
