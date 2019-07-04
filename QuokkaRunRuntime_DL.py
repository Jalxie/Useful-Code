from bokeh.core.properties import value
from bokeh.io import show, output_file
from bokeh.plotting import figure
from bokeh.models import ColumnDataSource, Range1d, LabelSet, Label

output_file("QuokkaRunRuntime.html")

Modes = ['ComboHigh', 'ComboMedium', 'ComboLow', 'ComboHalo', 'ComboHaloFlash', 'SpotHigh', 'SpotMedium',' SpotLow', 'SpotHalo', 'SpotHaloFlash',
			'WideHigh', 'WideMedium', 'WideLow', 'WideHalo', 'WideHaloFlash', 'HaloHigh', 'HaloMedium', 'HaloLow', 'HaloFlash1', 'HaloFlash2']
reserves = ["Reserve 1", "Reserve 2", "Reserve 3"]
colors = ["#c9d9d3", "#718dbf", "#e84d60"]

data = {'Modes' : Modes,
        'Reserve 1'   : [2.77, 7.73, 25.13, 2.03, 2.40, 4.08, 11.43, 23.98, 2.58, 3.08, 10.08, 22.72, 46.32, 4.23, 6.23, 6.50, 13.37, 36.43, 13.93, 17.57],
        'Reserve 2'   : [0.48, 0.47,  1.22, 0.32, 0.35, 0.62,  0.93,  0.68, 0.47, 0.42,  1.08,  1.65,  2.33, 0.55, 0.52, 0.60,  1.12,  1.23,  0.75,  1.70],
        'Reserve 3'   : [0.52, 0.42,  1.07, 0.20, 0.32, 0.50,  0.50,  0.37, 0.35, 0.32,  1.53,  1.47,  2.18, 0.57, 0.77, 0.52,  0.63,  0.72,  0.38,  0.77]}

p = figure(x_range=Modes, plot_width = 1500, plot_height=700, title="Runtime(Hrs)",
           toolbar_location=None, tools="hover", tooltips="$name @Modes: @$name")

p.vbar_stack(reserves, x='Modes', width=0.7, color=colors, source=data,
             legend=[value(x) for x in reserves])

p.y_range.start = 0
p.x_range.range_padding = 0.1
p.xgrid.grid_line_color = None
p.axis.minor_tick_line_color = None
p.outline_line_color = None
p.legend.location = "top_left"
p.legend.orientation = "horizontal"

show(p)
