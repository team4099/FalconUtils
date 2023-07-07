import os
from jinja2 import Environment, FileSystemLoader

PATH = os.path.dirname(os.path.abspath(__file__))
TEMPLATE_ENVIRONMENT = Environment(
    autoescape=False,
    loader=FileSystemLoader(os.path.join(PATH, 'templates')),
    trim_blocks=False)

def render_template(template_filename, context):
    return TEMPLATE_ENVIRONMENT.get_template(template_filename).render(context)

def create_controller_file():
    fname = "src/main/kotlin/org/team4099/lib/units/derived/Controller.kt"
    outputs = ['Volt', 'Ampere', 'Velocity<Radian>', 'Velocity<Meter>', "Meter", "Velocity<Radian>"]
    output_aliases = ['Volts', 'Amps', 'RadiansPerSecond', "MetersPerSecond", "Meters", "DegreesPerSecond"]
    context = {
        'control_outputs': outputs,
        'output_aliases': output_aliases,
    }
    #
    with open(fname, 'w') as f:
        html = render_template('Controller.kt.jinja', context)
        f.write(html)

def main():
    create_controller_file()

if __name__ == "__main__":
    main()