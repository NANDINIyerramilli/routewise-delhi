import subprocess
from flask import Flask, render_template, request
import os
from stations import stations

app = Flask(__name__)
JAVA_DIR = "java"

@app.route("/", methods=["GET", "POST"])
def index():
    result = None
    if request.method == "POST":
        source = request.form["source"]
        destination = request.form["destination"]
        app.logger.info(f"Received source: '{source}', destination: '{destination}'")

        # Verify Java files exist
        java_files = [os.path.join(JAVA_DIR, f) for f in ["Main.java", "Edge.java", "MetroGraph.java"]]
        for java_file in java_files:
            if not os.path.exists(java_file):
                return render_template("index.html", result=f"Java file not found: {java_file}", stations=stations)

        # Compile Java files
        compile_cmd = ["javac"] + java_files
        try:
            compile_result = subprocess.run(compile_cmd, capture_output=True, text=True, check=True)
            app.logger.info("Java compilation successful")
        except subprocess.CalledProcessError as e:
            error_msg = f"Java compilation failed:\n{e.stderr}"
            app.logger.error(error_msg)
            return render_template("index.html", result=error_msg, stations=stations)

        # Run Java program with a timeout
        try:
            run_cmd = ["java", "-cp", JAVA_DIR, "Main", source, destination]
            app.logger.info(f"Running command: {' '.join(run_cmd)}")
            result = subprocess.check_output(run_cmd, stderr=subprocess.STDOUT, text=True, timeout=10)
            app.logger.info(f"Java output: {result}")
        except subprocess.CalledProcessError as e:
            error_msg = f"Error during Java execution:\n{e.output}"
            app.logger.error(error_msg)
            result = error_msg
        except subprocess.TimeoutExpired:
            error_msg = "Java program timed out after 10 seconds"
            app.logger.error(error_msg)
            result = error_msg

    return render_template("index.html", result=result, stations=stations)

if __name__ == "__main__":
    app.run(debug=True)