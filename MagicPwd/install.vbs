Set oFso = CreateObject("Scripting.FileSystemObject")
strCurPath = oFso.GetParentFolderName(Wscript.ScriptFullName)

Set WshShell = WScript.CreateObject("WScript.Shell")
WshShell.Environment("user").Item("CLASSPATH")=strCurPath & "\lib\;" & WshShell.Environment("user").Item("CLASSPATH")
strDesktop = WshShell.SpecialFolders("Desktop")

set oLnk = WshShell.CreateShortcut(strDesktop & "\ħ������.lnk")
oLnk.TargetPath = strCurPath & "\magicpwd.jar"
oLnk.WindowStyle = 1
oLnk.Hotkey = "Ctrl+Alt+M"
oLnk.IconLocation = strCurPath & "\logo\logo.ico, 0"
oLnk.Description = "ħ�����룬��ƽ̨������������"
oLnk.WorkingDirectory = strCurPath & "\"
oLnk.Save

set oUrl = WshShell.CreateShortcut(strDesktop & "\ħ��������ҳ.url")
oUrl.TargetPath = "http://magicpwd.com/"
oUrl.Save