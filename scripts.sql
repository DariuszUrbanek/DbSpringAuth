USE [emp]
GO

/****** Object:  Table [dbo].[employees]    Script Date: 16/08/2018 16:36:04 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[employees](
	[emp_no] [int] NOT NULL,
	[birth_date] [date] NOT NULL,
	[first_name] [varchar](14) NOT NULL,
	[last_name] [varchar](16) NOT NULL,
	[hire_date] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[emp_no] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

GO

/****** Object:  Table [dbo].[departments]    Script Date: 16/08/2018 16:36:11 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[departments](
	[dept_no] [char](4) NOT NULL,
	[dept_name] [varchar](40) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[dept_no] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[dept_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

GO

/****** Object:  Table [dbo].[salaries]    Script Date: 16/08/2018 16:36:39 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[salaries](
	[emp_no] [int] NOT NULL,
	[salary] [int] NOT NULL,
	[from_date] [date] NOT NULL,
	[to_date] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[emp_no] ASC,
	[from_date] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[salaries]  WITH CHECK ADD FOREIGN KEY([emp_no])
REFERENCES [dbo].[employees] ([emp_no])
ON DELETE CASCADE
GO

GO

/****** Object:  Table [dbo].[spring_user]    Script Date: 16/08/2018 16:36:58 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[spring_user](
	[username] [varchar](255) NOT NULL,
	[password] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

GO

/****** Object:  Table [dbo].[spring_role]    Script Date: 16/08/2018 16:37:16 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[spring_role](
	[name] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

GO

/****** Object:  Table [dbo].[spring_user_roles]    Script Date: 16/08/2018 16:37:29 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[spring_user_roles](
	[users_username] [varchar](255) NOT NULL,
	[roles_name] [varchar](255) NOT NULL
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[spring_user_roles]  WITH CHECK ADD  CONSTRAINT [FK5f84xoiuqo7hftpr4ymo7yp1p] FOREIGN KEY([roles_name])
REFERENCES [dbo].[spring_role] ([name])
GO

ALTER TABLE [dbo].[spring_user_roles] CHECK CONSTRAINT [FK5f84xoiuqo7hftpr4ymo7yp1p]
GO

ALTER TABLE [dbo].[spring_user_roles]  WITH CHECK ADD  CONSTRAINT [FKsidnegfifpae295tcpi031gr2] FOREIGN KEY([users_username])
REFERENCES [dbo].[spring_user] ([username])
GO

ALTER TABLE [dbo].[spring_user_roles] CHECK CONSTRAINT [FKsidnegfifpae295tcpi031gr2]
GO

GO

/****** Object:  Table [dbo].[dept_emp]    Script Date: 16/08/2018 16:37:49 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[dept_emp](
	[emp_no] [int] NOT NULL,
	[dept_no] [char](4) NOT NULL,
	[from_date] [date] NOT NULL,
	[to_date] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[emp_no] ASC,
	[dept_no] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[dept_emp]  WITH CHECK ADD FOREIGN KEY([dept_no])
REFERENCES [dbo].[departments] ([dept_no])
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[dept_emp]  WITH CHECK ADD FOREIGN KEY([emp_no])
REFERENCES [dbo].[employees] ([emp_no])
ON DELETE CASCADE
GO

GO

/****** Object:  Table [dbo].[dept_manager]    Script Date: 16/08/2018 16:38:03 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[dept_manager](
	[emp_no] [int] NOT NULL,
	[dept_no] [char](4) NOT NULL,
	[from_date] [date] NOT NULL,
	[to_date] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[emp_no] ASC,
	[dept_no] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[dept_manager]  WITH CHECK ADD FOREIGN KEY([dept_no])
REFERENCES [dbo].[departments] ([dept_no])
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[dept_manager]  WITH CHECK ADD FOREIGN KEY([emp_no])
REFERENCES [dbo].[employees] ([emp_no])
ON DELETE CASCADE
GO

GO

/****** Object:  Table [dbo].[titles]    Script Date: 16/08/2018 16:38:15 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[titles](
	[emp_no] [int] NOT NULL,
	[title] [varchar](50) NOT NULL,
	[from_date] [date] NOT NULL,
	[to_date] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[emp_no] ASC,
	[title] ASC,
	[from_date] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[titles]  WITH CHECK ADD FOREIGN KEY([emp_no])
REFERENCES [dbo].[employees] ([emp_no])
ON DELETE CASCADE
GO


