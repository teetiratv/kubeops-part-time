Describe Git branching strategies (Git-flow, single branch, feature branch etc.) which you have used and what purpose does it serves. 
- `Feature branch เวลาทำ feature ใหม่`
- `Release branch เวลาแยก release (ส่วนมากทำเป็น trunk base deployment ก็ใช้ใช้ main ไม่ก็ master ไปเลย)`
- `Hotfix branch เวลามี fix แก้บัค`
- `Etc`

How do you revert a commit that has already been pushed and made public? 
- `git reset --hard <commit-hash> แล้วก็ push ขึ้นไป มันจะมีหลาย option แต่จำไม่ได้ (HARD ,...)`

How do you normally solve conflicts in a feature branch before merge?
- `ดูว่ามัน conflicts (git log --merge ,git diff ) ตรงไหน แล้วก็แก้ไข จากนั้นก็ commit แล้ว push กลับไป แล้วค่อย merge`

“200 OK” what does it mean and show use case this HTTP Status?
- `เรียก http req ไปแล้วสามารถใช้งานได้`

“201 Created” what does it mean and show use case this HTTP Status?
- `ใช้ res กลับมาตอนนี้มีการสร้างข้อมูล`

“301 Moved Permanently” what does it mean and show use case this HTTP Status?
- `ไม่ค่อยใช้ แต่ที่ไปอ่านมาคือเอาไว้ Redirect เวลาเรียกมาที่ url ที่ไม่ได้ใช้ มีผลกับการทำ SEO`

“400 Bad Request” what does it mean and how to identify the problem?
- `เรียก http req มาแล้วส่งข้อมูลมาผิดหรือไม่ครบตามที่เรากำหนด`

“401 Unauthorized” what does it mean and how to identify the problem?
- `สิ่งที่ต้องการจำเป็นต้องมีการยืนยันตัวตน เช่นต้อง login หรือต้องการค่างบางอย่างเพื่อระบุตัวตัวตนในทำงานต่อไป`

“403 Forbidden” what does it mean and how to identify the problem?
- `ห้ามเรียก ห้ามเข้า`

“404 Not Found” what does it mean and how to identify the problem?
- `ไม่มีสิ่งที่ต้องการอยู่ ไม่มีหน้านี้อยู่`

“500 Internal Server Error” what does it mean and how to identify the problem?
- `server พัง`

“502 Bad Gateway” what does it mean and how to identify the problem?
- `Gateway หรือ poxxy พัง`

“503 Service Unavailable” what does it mean and how to identify the problem?
- `ไม่พร้อมให้บริการ`

“504 Gateway Timeout” what does it mean and how to identify the problem?
- `Gateway หรือ poxxy ตอบสนองช้าเกินเวลากำหนด`


What are Linux network tools do you use for troubleshooting network problems as well as usage scenarios for each tool?

- `nmap,curl,ping จำไม่ได้`


Intermediate

Assume we have an application that is designed as below. Our application stopped responding due to an extremely high number of clients in some circumstances.
We have tried scaling a number of API Gateway and Service A nodes but it didn’t help. What are the possible problems that lies in our system in which components and how to fix them?
- `1) ถ้าจะเอาจริงจังจริงๆต้องดูตั้งแต่ FN เรียกเข้ามา ว่าเรียกเข้ามามีการ call APIs ซ้ำๆมั้ย เพราะเขาอาจจะทำเป็น 1 หน้ามีหลาย component แล้วแต่ละ component ก็เรียก APIs เดิมซ้ำๆอันนี้ต้องไป tune ที่ FN`
- `2)มาดูที่ APIs Gateway ว่าตัว cluster มันรับ load ได้แค่ไหนถึง limit หรือยัง แล้วการ setup เป็นยังไง tuning rate limit ไว้ได้หรือปล่าว หรือ ถ้ามี WAF มันโยน taffic ทิ้งหรือปล่าว`
- `3) ดูว่า app service ที่ run อยู่มันพอที่จะรับ taffic ที่เข้ามาได้มั้ย ถ้าไม่พอก็ scale เพิ่ม อันนี้ต้องดูจากผล load test ที่ทำไว้`
- `4) database เป็นยังไง เราจะ scale แค่ app ไม่ได้ มันต้อง scale คู่กัน (อื่น redis,kafka,etc)`

How do you keep the docker image smallest as possible?
- `พยายามอย่าติดตั้งอะไรที่ไม่ได้ใช้เข้าไปใน image ทำให้มีแค่ตัว runtime กับ binary ของ app ก็พอ หรือลองดูว่าทำเป็น muti stage build ได้มั้ย`

What is the difference between overlay, bridge, host network in Docker? When to use each of them?
 - `host รันอยู่บน host network เลย ซึ่งสามารถ full access ได้จาก host interface`
- `bridge network ภายใน (แยก host กับ container ออกาจากกัน)`
- `overlay เอาไว้ทำ network ขนาดใหญ่ให้ containner คุยกับข้าม host network`

How does the Kubernetes service talk to each other in the same cluster?
- `kube proxy `

What’s different between L2, L4, and L7 Load balancers? When to use it?
- `l2 อันนี้ไม่เคยใช้ น่าจะต่ำไป เท่าที่ไปดูมาน่าจะเกี่ยวกับ hardware ละ`
- `l4 ระดับ Server โดยจะแบ่ง load ตามเครื่อง server`
- `l7 ระดับ Application แบ่ง load จะให้เข้า Application ยังไงบ้าง (http load balancers)`



Professional
 
Assume that you are using a private cloud for your infrastructure. How do you manage logs, metrics, and alerts for your infrastructure and applications? Which tools do you use and why?
- `ELK เพราะมันไม่มีค่าใช้จ่าย แล้วก็ยังมี kibana ที่เอามาช่วยทำ metrics ต่างๆได้ (ที่ทำงานประจำผมใช้ newrelic )`
How do you secure the following?
·  	application
- `จำกัดสิทธิการเข้าถึง ให้ใช้เท่าที่ใช้งานจริงๆ และไม่นำพวก credentials มาใส่ไว้ใน app`
·  	infrastructure
- `ห้ามบุคคลที่ไม่ได้รับอนุญาตเข้าไปในพื้นที่ ต้องมีการป้องกันภัยธรรมชาติ เช่น ไฟฟ้าสำรอง`
·  	data
- `มีการเข้ารหัสข้อมูลที่เป็นพวก PII data ในการเก็บ log หรือการเก็บข้อมูลไว้ที่แหล่งอื่นๆที่ไม่ใช้ฐานข้อมูลหลัก และต้องมีการทำ backup สม่ำเสมอ`

Base on your experience, how do you reduce your service downtime as much as possible during
·  	software upgrade
- `ต้องมีการทำ rolling update (ตรวจสอบว่า software พร้อมทำงานก่อนถึงค่อย swicth trafficเข้ามา) `
·  	database migration
- `ทำตอนที่ผู้ใช้งานหน่อยๆ หรืออาจจะแยก database ออกมาเป็นสองเครื่อง รอให้ migration เสร็จก่อนแล้วค่อย swicth ไปใช้ของใหม่`
·  	incident
- `roll back กลับไป version ก่อนหน้าที่ใช้งานได้ปกติ และหาสาเหตุที่หลัง`
Configuration management
a. 	Which Among Puppet, chef, Ansible, or another is the best Configuration management tool?
- `ผมไม่รู้ว่าอันไหนดีกว่ากัน มันน่าจะแล้วแต่งานนะ รู้แค่เคยใช้ Ansible `
b. 	Why?
- `Ansible มันก็เปลี่ยนการทำงานไปเลยจากแบบเก่าต้องมานั่ง ต่อ ssh ไปที่เครื่องต่างๆเพื่อ run คำสั่ง deploy ตัว Ansible ก็จะมาช่วยจัดการเรื่องพวกนี้`
c. 	Do you still need to use it if you already have docker-swarm or Kubernetes?
- `จริงมันก็ใช้ได้ เพื่ออาจจะทำประมาณว่าให้แค่เครื่องนี้ สั่ง k8s cluster ตัวนี้ได้ตัวเดียวอะไรประมาณนี้อะ ก็ให้ Ansible มันพาไปเครื่องนั้นๆ`
How do you design your Kubernetes cluster? what DNS, CNI, ingression is being used? Why?
- `ไม่รู้เลยครับ`
How do you measure service quality to give the best experience to your customer? (SLO, SLA)
- `error rate ,response time,downtime`


