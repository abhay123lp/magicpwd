Set oFso = CreateObject("Scripting.FileSystemObject")
strCurPath = oFso.GetParentFolderName(Wscript.ScriptFullName)

Set WshShell = WScript.CreateObject("WScript.Shell")
strDesktop = WshShell.SpecialFolders("Desktop") :'�����ļ��С����桱

Rem �����洴��һ�����±���ݷ�ʽ
set oLnk = WshShell.CreateShortcut(strDesktop & "\ħ������.lnk")
oLnk.TargetPath = strCurPath & "\magicpwd.jar" : 'Ŀ��
oLnk.WindowStyle = 1 :'����1Ĭ�ϴ��ڼ������3��󻯼������7��С��
oLnk.Hotkey = "Ctrl+Alt+M" : '��ݼ�
oLnk.IconLocation = strCurPath & "\logo\logo.ico, 0" : 'ͼ��
oLnk.Description = "ħ�����룬��ƽ̨������������" : '��ע
oLnk.WorkingDirectory = strCurPath & "\" : '��ʼλ��
oLnk.Save : '���������ݷ�ʽ

Rem �����洴��һ����΢���й�����Url��ݷ�ʽ
set oUrl = WshShell.CreateShortcut(strDesktop & "\ħ��������ҳ.url")
oUrl.TargetPath = "http://magicpwd.com/"
oUrl.Hotkey = "Ctrl+Alt+H"
oUrl.Save