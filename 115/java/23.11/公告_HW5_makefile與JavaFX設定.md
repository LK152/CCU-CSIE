# 【HW5 公告】關於 Makefile 與 JavaFX 路徑設定（請務必閱讀）

各位同學好，

HW5 是 JavaFX 程式（彈跳球）。由於 **JDK 11 以後 JavaFX 已不再內建於 JDK**，編譯與執行時都必須額外指定 JavaFX 函式庫（`lib` 資料夾）的路徑。為了讓助教批改時能順利編譯、執行你們的程式，請依下列規範撰寫 Makefile。

---

## 一、Makefile 規範（重要，照做才不會被扣分／無法執行）

請在 Makefile 最上方用變數 **`PATH_TO_FX`** 來代表 JavaFX 的 `lib` 路徑，並用 `?=` 設定你自己電腦上的預設值：

```makefile
# 這一行填「你自己電腦上」JavaFX 的 lib 路徑；助教批改時會用環境變數自動覆蓋，你不用改
PATH_TO_FX ?= C:/javafx-sdk-21/lib

MODULES = javafx.controls,javafx.graphics
MAIN    = BouncingBalls        # ← 改成你「含 main 的主類別名稱」

all:
	javac --module-path "$(PATH_TO_FX)" --add-modules $(MODULES) *.java

run: all
	java --module-path "$(PATH_TO_FX)" --add-modules $(MODULES) $(MAIN)

clean:
	rm -f *.class

.PHONY: all run clean
```

**為什麼這樣寫就好？**
- `?=` 的意思是「如果環境變數 `PATH_TO_FX` 已存在，就用環境變數；否則才用這個預設值」。
- 助教的批改機上已設好 `PATH_TO_FX` 環境變數，所以會**自動覆蓋**你寫的預設路徑 → 你不必猜助教的路徑，助教也不必改你的檔案。
- 你只要確保：① 有 `PATH_TO_FX` 這個變數、② 編譯/執行用 `--module-path "$(PATH_TO_FX)" --add-modules javafx.controls,javafx.graphics`、③ `MAIN` 改成你自己的主類別名。

> ⚠️ **致命陷阱：Makefile 規則（`all:`、`run:`、`clean:` 下面那幾行）開頭必須是「Tab 鍵」，不能是空白鍵！**
> 從網頁/文件複製貼上常會把 Tab 變成空白，導致出現 `*** missing separator` 錯誤。貼上後請務必確認是 Tab。

---

## 二、如何在自己電腦安裝 JavaFX 並設定 PATH_TO_FX

### 1) 下載 JavaFX SDK
到 <https://gluonhq.com/products/javafx/> 下載 **JavaFX SDK**（選你作業系統、x64、SDK）。建議選一個 LTS 版本（例如 JavaFX 21 或更新版皆可）。解壓後會得到一個含 `lib` 子資料夾的目錄，例如：
- Windows：`C:\javafx-sdk-21\lib`
- macOS：`/Users/你的帳號/javafx-sdk-21/lib`

### 2)（可選但推薦）設定環境變數 PATH_TO_FX
設了之後，連自己測試都不用每次打路徑：

**Windows（PowerShell）**
```powershell
setx PATH_TO_FX "C:/javafx-sdk-21/lib"
```
設定後請**重新開啟終端機**才會生效。

**macOS / Linux（zsh 或 bash）**
```bash
echo 'export PATH_TO_FX="/Users/你的帳號/javafx-sdk-21/lib"' >> ~/.zshrc
source ~/.zshrc
```
（若用 bash，把 `~/.zshrc` 換成 `~/.bashrc`。）

> 就算你不設環境變數也沒關係——只要 Makefile 裡 `PATH_TO_FX ?= ...` 的預設值填的是你電腦上正確的路徑，你自己 `make` 就能跑。環境變數只是讓助教批改時 0 改動。

### 3) 測試
```
make
make run
make clean
```
能編譯、能跳出視窗、能清除 `.class`，就代表設定正確。

---

## 三、繳交格式提醒（再次強調）

- 壓縮成 **`學號_姓名.zip`**，內含：`學號_readme.pdf`、`makefile`、`.java`。
- **不要**交 `.class`；**有交 `.class` 但沒交 `.java` 一律 0 分**。
- Readme 需含：編譯與執行方式、程式碼說明（函式、變數、main 執行流程等）。

有任何問題歡迎在課程討論區或來信詢問助教。

祝 coding 順利！
