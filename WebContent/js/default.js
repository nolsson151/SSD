var editor = CodeMirror.fromTextArea(document.getElementById("snippet"), {
    lineNumbers: true,
    matchBrackets: true,
    mode: "text/x-java"
  });

function myFunction()
{
    var message = editor.getValue();
    message.submit();
}