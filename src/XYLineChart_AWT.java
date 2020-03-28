import java.awt.Color;
import java.awt.BasicStroke;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class XYLineChart_AWT extends ApplicationFrame {

    //конструктор, если нужно создать график с одной ленией
    public XYLineChart_AWT(String applicationTitle, String chartTitle,
                           double[] arrData,
                           String string,
                           String OXName,
                           String OYName) {
        super(applicationTitle);
        JFreeChart XYLineChart = ChartFactory.createXYLineChart(
                chartTitle,
                OXName,
                OYName,
                createDataSet(arrData, string),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(XYLineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560 , 367));
        final XYPlot plot = XYLineChart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        plot.setRenderer(renderer);
        setContentPane(chartPanel);
    }

    //конструктор, если нужно создать один единый график с множеством линий
    public XYLineChart_AWT(String applicationTitle, String chartTitle,
                           ArrayList<double[]> listOfArrays,
                           String[] arrNames,
                           String OXName,
                           String OYName) {
        super(applicationTitle);
        JFreeChart XYLineChart = ChartFactory.createXYLineChart(
                chartTitle,
                OXName,
                OYName,
                createAllInOneDataSet(listOfArrays, arrNames),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(XYLineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560 , 367));
        final XYPlot plot = XYLineChart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        for (int i = 0; i < listOfArrays.size(); i++) {
            renderer.setSeriesPaint(3, new Color((int)(Math.random() * 0x1000000)));
            renderer.setSeriesStroke(i, new BasicStroke(2.0f));
        }
        plot.setRenderer(renderer);
        setContentPane(chartPanel);
    }

    public XYDataset createAllInOneDataSet(ArrayList<double[]> listOfArrays, String[] arrNames) {
        final XYSeriesCollection dataSet = new XYSeriesCollection();
        for (int i = 0; i < listOfArrays.size(); i++) {
            double[] array = listOfArrays.get(i);
            final XYSeries data = new XYSeries(arrNames[i]);
            for (int j = 0; j < array.length; j++) {
                data.add(j + 1, array[j]);
            }
            dataSet.addSeries(data);
        }
        return dataSet;
    }

    public XYDataset createDataSet(double[] array, String string) {
        final XYSeries data = new XYSeries(string);
        for (int i = 0; i < array.length; i++) {
            data.add(i + 1, array[i]);
        }
        final XYSeriesCollection dataSet = new XYSeriesCollection( );
        dataSet.addSeries(data);
        return dataSet;
    }
}
