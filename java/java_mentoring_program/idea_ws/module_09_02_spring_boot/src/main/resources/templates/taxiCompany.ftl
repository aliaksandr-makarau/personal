<!DOCTYPE html>
<html lang="en">
    <body>
        <h2>List of taxi companies</h2>
        <table>
            <thead>
                <th>Name</th>
                <th>Address</th>
                <th>Rate</th>
            </thead>
            <tbody>
                <#list taxiCompanies as taxiCompany>
                    <tr>
                        <td>${taxiCompany.name}</td>
                        <td>${taxiCompany.address}</td>
                        <td>${taxiCompany.rate}</td>
                    </tr>
                </#list>
            </tbody>
        </table>
    </body>
</html>